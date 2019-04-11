package com.mengsoftstudio.android.footballmobile.contracts

import com.mengsoftstudio.android.footballmobile.models.Match

interface MatchFavoriteContract {

    interface View {

        fun onShowLoading()
        fun onSuccessFetchData(matchList: List<Match>)
        fun onFailureFetchData()
        fun onHideLoading()

    }

    interface Presenter {

        fun getMatchFavorite()
        fun onDestroyPresenter()

    }

}