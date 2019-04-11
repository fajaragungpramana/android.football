package com.mengsoftstudio.android.footballmobile.contracts

import com.mengsoftstudio.android.footballmobile.models.Team

interface TeamContract {

    interface View {

        fun onShowLoading()
        fun onSuccessFetchData(teamList: List<Team>)
        fun onFailureFetchData()
        fun onHideLoading()

    }

    interface Presenter {

        fun getAllTeamLeague(l: String)
        fun onDestroyPresenter()

    }

}