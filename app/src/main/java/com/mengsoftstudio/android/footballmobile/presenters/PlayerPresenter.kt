package com.mengsoftstudio.android.footballmobile.presenters

import com.mengsoftstudio.android.footballmobile.contracts.PlayerContract
import com.mengsoftstudio.android.footballmobile.models.response.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*
import javax.inject.Inject

class PlayerPresenter @Inject constructor(private val view: PlayerContract.View,
                                          private val apiRepositoryImpl: ApiRepositoryImpl) : PlayerContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getTeamPlayer(id: String) {

        view.onShowLoading()
        compositeDisposable.add(apiRepositoryImpl.getTeamPlayer(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(object : ResourceSubscriber<Response.PlayerResponse>() {

                    override fun onComplete() { view.onHideLoading() }

                    override fun onNext(t: Response.PlayerResponse) { view.onSuccessFetchData(t.player) }

                    override fun onError(t: Throwable?) {
                        view.onFailureFetchData()
                        view.onSuccessFetchData(Collections.emptyList())
                    }

                }))

    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }

}