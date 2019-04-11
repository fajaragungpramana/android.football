package com.mengsoftstudio.android.footballmobile.contracts

import com.mengsoftstudio.android.footballmobile.models.Badge
import com.mengsoftstudio.android.footballmobile.models.MatchFavorite

interface MatchDetailContract {

    interface View {

        fun onShowLoading()
        fun setHomeBadge(badge: Badge)
        fun setAwayBadge(badge: Badge)
        fun onFailureFetchData()
        fun onHideLoading()

        fun hasMatchFavorite(matchFavoriteList: List<MatchFavorite>)

    }

    interface Presenter {

        fun getHomeBadge(id: String?)
        fun getAwayBadge(id: String?)

        fun setMatchFavorite(idEvent: String)
        fun removeMatchFavorite(idEvent: String)
        fun hasMatchFavorite(idEvent: String)


        fun onDestroyPresenter()

    }

}