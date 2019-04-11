package com.mengsoftstudio.android.footballmobile.contracts

import com.mengsoftstudio.android.footballmobile.models.Team

interface TeamFavoriteContract {

    interface View {

        fun onShowLoading()
        fun onSuccessFetchData(teamList: List<Team>)
        fun onFailureFetchData()
        fun onHideLoading()

    }

    interface Presenter {

        fun getTeamFavorite()
        fun onDestroyPresenter()

    }


}