package com.mengsoftstudio.android.footballmobile.presenters

import com.mengsoftstudio.android.footballmobile.contracts.SearchTeamContract
import com.mengsoftstudio.android.footballmobile.models.response.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*
import javax.inject.Inject

class SearchTeamPresenter @Inject constructor(private val view: SearchTeamContract.View,
                                              private val apiRepositoryImpl: ApiRepositoryImpl) : SearchTeamContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getSearchTeam(query: String) {

        view.onShowLoading()
        compositeDisposable.add(apiRepositoryImpl.getSearchTeam(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(object : ResourceSubscriber<Response.SearchTeamResponse>() {

                    override fun onComplete() { view.onHideLoading() }

                    override fun onNext(t: Response.SearchTeamResponse) { view.onSuccessFetchData(t.teams) }

                    override fun onError(t: Throwable?) {
                        view.onFailureFetchData()
                        view.onSuccessFetchData(Collections.emptyList())
                    }

                }))

    }

    override fun onDestroyPresenter() { compositeDisposable.dispose() }


}