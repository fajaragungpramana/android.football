package com.mengsoftstudio.android.footballmobile.contracts

import com.mengsoftstudio.android.footballmobile.models.Match

interface SearchMatchContract {

    interface View {

        fun onShowLoading()
        fun onSuccessFetchData(matchList: List<Match>)
        fun onFailureFetchData()
        fun onHideLoading()

    }

    interface Presenter {

        fun getSearchMatch(query: String)
        fun onDestroyPresenter()

    }

}