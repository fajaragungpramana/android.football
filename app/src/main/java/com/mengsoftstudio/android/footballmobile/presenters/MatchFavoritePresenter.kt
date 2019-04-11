package com.mengsoftstudio.android.footballmobile.presenters

import com.mengsoftstudio.android.footballmobile.contracts.MatchFavoriteContract
import com.mengsoftstudio.android.footballmobile.models.Match
import com.mengsoftstudio.android.footballmobile.models.response.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import javax.inject.Inject

class MatchFavoritePresenter @Inject constructor(private val view: MatchFavoriteContract.View,
                                                 private val apiRepositoryImpl: ApiRepositoryImpl,
                                                 private val localRepositoryImpl: LocalRepositoryImpl) : MatchFavoriteContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getMatchFavorite() {

        view.onShowLoading()
        val matchFavorite = localRepositoryImpl.getMatchFavorite()
        val matchFavoriteList = mutableListOf<Match>()

        for(match in matchFavorite) {

            compositeDisposable.add(apiRepositoryImpl.getMatchFavorite(match.idEvent!!)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(object : ResourceSubscriber<Response.MatchFavoriteResponse>() {
                    override fun onComplete() { view.onHideLoading() }

                    override fun onNext(t: Response.MatchFavoriteResponse) {
                        matchFavoriteList.add(t.event[0])

                        view.onSuccessFetchData(matchFavoriteList)
                    }

                    override fun onError(t: Throwable?) {
                        view.onFailureFetchData()
                    }

                })
            )

        }

        if(matchFavorite.isEmpty()) {
            view.onHideLoading()
            view.onSuccessFetchData(matchFavoriteList)
        }

    }

    override fun onDestroyPresenter() { compositeDisposable.dispose() }

}