package com.mengsoftstudio.android.footballmobile.presenters

import com.mengsoftstudio.android.footballmobile.contracts.TeamContract
import com.mengsoftstudio.android.footballmobile.models.response.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*
import javax.inject.Inject

class TeamPresenter @Inject constructor(private val view: TeamContract.View,
                    private val apiRepositoryImpl: ApiRepositoryImpl) : TeamContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getAllTeamLeague(l: String) {

        view.onShowLoading()
        compositeDisposable.add(apiRepositoryImpl.getAllTeamLeague(l)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<Response.TeamResponse>() {

                override fun onComplete() { view.onHideLoading() }

                override fun onNext(t: Response.TeamResponse) { view.onSuccessFetchData(t.teams) }

                override fun onError(t: Throwable?) {
                    view.onFailureFetchData()
                    view.onSuccessFetchData(Collections.emptyList())
                }

            }))

    }

    override fun onDestroyPresenter() { compositeDisposable.dispose() }

}