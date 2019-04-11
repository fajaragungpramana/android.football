package com.mengsoftstudio.android.footballmobile.views.fragment.tab

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.contracts.MatchContract
import com.mengsoftstudio.android.footballmobile.extensions.gone
import com.mengsoftstudio.android.footballmobile.extensions.visible
import com.mengsoftstudio.android.footballmobile.models.Match
import com.mengsoftstudio.android.footballmobile.presenters.MatchPresenter
import com.mengsoftstudio.android.footballmobile.views.adapter.MatchAdapter
import com.mengsoftstudio.android.footballmobile.views.base.BaseFragment
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.android.synthetic.main.support_no_connection.view.*
import kotlinx.android.synthetic.main.tab_match.view.*
import javax.inject.Inject

class NextMatchTab : BaseFragment(), MatchContract.View {

    private lateinit var ui: View

    @Inject lateinit var presenter: MatchPresenter

    override fun onFragmentCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = inflater.inflate(R.layout.tab_match, container, false)

        RxJavaPlugins.setErrorHandler{}

        ui.spin_league.adapter = ArrayAdapter( activity!!, R.layout.support_spinner, resources.getStringArray(R.array.league_list) )
        ui.spin_league.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                when( ui.spin_league.selectedItem.toString() ) {

                    "English Premier League" -> presenter.getNextMatch("4328")
                    "Italian Serie A" -> presenter.getNextMatch("4332")
                    "Italian Serie B" -> presenter.getNextMatch("4394")
                    "Spanish La Liga" -> presenter.getNextMatch("4335")
                    "German Bundesliga" -> presenter.getNextMatch("4331")
                    "French Ligue 1" -> presenter.getNextMatch("4334")
                    "French Ligue 2" -> presenter.getNextMatch("4401")

                }

            }

        }

        ui.btn_try_gain.setOnClickListener {
            presenter.getNextMatch("4328")
        }

        return ui
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDestroyPresenter()

    }

    override fun onShowLoading() {
        ui.pb_match.visible()
        ui.rv_match.gone()
        ui.include_no_connection.gone()
    }

    override fun onSuccessFetchData(matchList: List<Match>) {
        ui.rv_match.layoutManager = LinearLayoutManager(activity)
        ui.rv_match.adapter = MatchAdapter(matchList, activity!!)
    }

    override fun onFailureFetchData() {
        ui.include_no_connection.visible()
        ui.rv_match.gone()
        ui.pb_match.gone()
    }

    override fun onHideLoading() {
        ui.pb_match.gone()
        ui.rv_match.visible()
        ui.include_no_connection.gone()
    }

}