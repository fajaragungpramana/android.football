package com.mengsoftstudio.android.footballmobile.presenters

import com.mengsoftstudio.android.footballmobile.contracts.MatchDetailContract
import com.mengsoftstudio.android.footballmobile.models.response.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import javax.inject.Inject

class MatchDetailPresenter @Inject constructor(private val view: MatchDetailContract.View,
                                               private val apiRepositoryImpl: ApiRepositoryImpl,
                                               private val localRepositoryImpl: LocalRepositoryImpl) : MatchDetailContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getHomeBadge(id: String?) {

        view.onShowLoading()
        compositeDisposable.add(apiRepositoryImpl.getTeamBadge(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<Response.BadgeResponse>() {

                override fun onComplete() { view.onHideLoading() }

                override fun onNext(t: Response.BadgeResponse) { view.setHomeBadge(t.badge[0]) }

                override fun onError(t: Throwable?) { view.onFailureFetchData() }

            }))

    }

    override fun getAwayBadge(id: String?) {

        view.onShowLoading()
        compositeDisposable.add(apiRepositoryImpl.getTeamBadge(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<Response.BadgeResponse>() {

                override fun onComplete() { view.onHideLoading() }

                override fun onNext(t: Response.BadgeResponse) { view.setAwayBadge(t.badge[0]) }

                override fun onError(t: Throwable?) { view.onFailureFetchData() }

            }))

    }

    override fun hasMatchFavorite(idEvent: String) {
        view.hasMatchFavorite( localRepositoryImpl.hasMatchFavorite(idEvent) )
    }

    override fun setMatchFavorite(idEvent: String) {
        localRepositoryImpl.setMatchFavorite(idEvent)
    }

    override fun removeMatchFavorite(idEvent: String) {
        localRepositoryImpl.removeMatchFavorite(idEvent)
    }

    override fun onDestroyPresenter() { compositeDisposable.dispose() }

}