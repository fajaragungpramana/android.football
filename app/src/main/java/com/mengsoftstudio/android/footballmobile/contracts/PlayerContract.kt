package com.mengsoftstudio.android.footballmobile.contracts

import com.mengsoftstudio.android.footballmobile.models.Player

interface PlayerContract {

    interface View {

        fun onShowLoading()
        fun onSuccessFetchData(playerList: List<Player>)
        fun onFailureFetchData()
        fun onHideLoading()

    }

    interface Presenter {

        fun getTeamPlayer(id: String)
        fun onDestroyPresenter()

    }

}