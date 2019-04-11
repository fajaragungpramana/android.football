package com.mengsoftstudio.android.footballmobile.presenters

import com.mengsoftstudio.android.footballmobile.contracts.SearchMatchContract
import com.mengsoftstudio.android.footballmobile.models.response.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*
import javax.inject.Inject

class SearchMatchPresenter @Inject constructor(private val view: SearchMatchContract.View,
                                               private val apiRepositoryImpl: ApiRepositoryImpl) : SearchMatchContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getSearchMatch(query: String) {

        view.onShowLoading()
        compositeDisposable.add(apiRepositoryImpl.getSearchMatch(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(object : ResourceSubscriber<Response.SearchMatchResponse>() {

                    override fun onComplete() { view.onHideLoading() }

                    override fun onNext(t: Response.SearchMatchResponse) { view.onSuccessFetchData(t.event) }

                    override fun onError(t: Throwable?) {
                        view.onFailureFetchData()
                        view.onSuccessFetchData(Collections.emptyList())
                    }

                }))

    }

    override fun onDestroyPresenter() { compositeDisposable.dispose() }


}