package com.mengsoftstudio.android.footballmobile.presenters

import com.mengsoftstudio.android.footballmobile.contracts.TeamFavoriteContract
import com.mengsoftstudio.android.footballmobile.models.Team
import com.mengsoftstudio.android.footballmobile.models.response.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*
import javax.inject.Inject

class TeamFavoritePresenter @Inject constructor(private val view: TeamFavoriteContract.View,
                                                private val apiRepositoryImpl: ApiRepositoryImpl,
                                                private val localRepositoryImpl: LocalRepositoryImpl) : TeamFavoriteContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getTeamFavorite() {

        view.onShowLoading()
        val teamFavorite = localRepositoryImpl.getTeamFavorite()
        val teamFavoriteList = mutableListOf<Team>()

        for(team in teamFavorite) {

            compositeDisposable.add(apiRepositoryImpl.getTeamFavorite(team.idTeam!!)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribeWith(object : ResourceSubscriber<Response.TeamFavoriteResponse>() {

                        override fun onComplete() { view.onHideLoading() }

                        override fun onNext(t: Response.TeamFavoriteResponse) {
                            teamFavoriteList.add(t.teams[0])

                            view.onSuccessFetchData(teamFavoriteList)
                        }

                        override fun onError(t: Throwable?) {
                            view.onFailureFetchData()
                            view.onSuccessFetchData(Collections.emptyList())
                        }

                    }))

        }

        if(teamFavorite.isEmpty()) {
            view.onHideLoading()
            view.onSuccessFetchData(teamFavoriteList)
        }

    }

    override fun onDestroyPresenter() { compositeDisposable.dispose() }

}