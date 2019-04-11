package com.mengsoftstudio.android.footballmobile.presenters

import com.mengsoftstudio.android.footballmobile.contracts.MatchContract
import com.mengsoftstudio.android.footballmobile.models.response.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*
import javax.inject.Inject

class MatchPresenter @Inject constructor(private val view: MatchContract.View,
                     private val apiRepositoryImpl: ApiRepositoryImpl) : MatchContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getNextMatch(id: String) {

        view.onShowLoading()
        compositeDisposable.add(apiRepositoryImpl.getEventsNextMatch(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<Response.MatchResponse>() {

                override fun onComplete() { view.onHideLoading() }

                override fun onNext(t: Response.MatchResponse) { view.onSuccessFetchData(t.events) }

                override fun onError(t: Throwable?) {
                    view.onFailureFetchData()
                    view.onSuccessFetchData(Collections.emptyList())
                }

            }))

    }

    override fun getLastMatch(id: String) {

        view.onShowLoading()
        compositeDisposable.add(apiRepositoryImpl.getEventsLastMatch(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<Response.MatchResponse>() {

                override fun onComplete() { view.onHideLoading() }

                override fun onNext(t: Response.MatchResponse) { view.onSuccessFetchData(t.events) }

                override fun onError(t: Throwable?) {
                    view.onFailureFetchData()
                    view.onSuccessFetchData(Collections.emptyList())
                }

            }))

    }

    override fun onDestroyPresenter() { compositeDisposable.dispose() }

}