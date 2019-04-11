package com.mengsoftstudio.android.footballmobile.contracts

import com.mengsoftstudio.android.footballmobile.models.Match

interface MatchContract {

    interface View {

        fun onShowLoading()
        fun onSuccessFetchData(matchList: List<Match>)
        fun onFailureFetchData()
        fun onHideLoading()

    }

    interface Presenter {

        fun getNextMatch(id: String)
        fun getLastMatch(id: String)
        fun onDestroyPresenter()

    }

}