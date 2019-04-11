package com.mengsoftstudio.android.footballmobile.views.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.contracts.TeamContract
import com.mengsoftstudio.android.footballmobile.extensions.gone
import com.mengsoftstudio.android.footballmobile.extensions.visible
import com.mengsoftstudio.android.footballmobile.models.Team
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import com.mengsoftstudio.android.footballmobile.presenters.TeamPresenter
import com.mengsoftstudio.android.footballmobile.views.activity.SearchTeamActivity
import com.mengsoftstudio.android.footballmobile.views.adapter.TeamAdapter
import com.mengsoftstudio.android.footballmobile.views.base.BaseFragment
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.android.synthetic.main.fragment_teams.view.*
import kotlinx.android.synthetic.main.support_no_connection.view.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject

class TeamsFragment : BaseFragment(), TeamContract.View {

    private lateinit var ui: View

    @Inject lateinit var presenter: TeamPresenter

    override fun onFragmentCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = inflater.inflate(R.layout.fragment_teams, container, false)
        setHasOptionsMenu(true)

        RxJavaPlugins.setErrorHandler {}

        ui.spin_league.adapter = ArrayAdapter( activity!!, R.layout.support_spinner, resources.getStringArray(R.array.league_list) )
        ui.spin_league.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                when( ui.spin_league.selectedItem.toString() ) {

                    "English Premier League" -> presenter.getAllTeamLeague("English Premier League")
                    "Italian Serie A" -> presenter.getAllTeamLeague("Italian Serie A")
                    "Italian Serie B" -> presenter.getAllTeamLeague("Italian Serie B")
                    "Spanish La Liga" -> presenter.getAllTeamLeague("Spanish La Liga")
                    "German Bundesliga" -> presenter.getAllTeamLeague("German Bundesliga")
                    "French Ligue 1" -> presenter.getAllTeamLeague("French Ligue 1")
                    "French Ligue 2" -> presenter.getAllTeamLeague("French Ligue 2")

                }

            }

        }

        ui.btn_try_gain.setOnClickListener { presenter.getAllTeamLeague("English Premier League") }

        return ui
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDestroyPresenter()

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        val search = menu?.findItem(R.id.action_search)?.actionView as SearchView
        search.queryHint = getString(R.string.query_hint_search_team)
        search.isSubmitButtonEnabled = true

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {

                activity?.startActivity(activity?.intentFor<SearchTeamActivity>(Constant.INTENT_TAG_SEARCH_TEAM to query)
                        ?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))

                return true
            }

            override fun onQueryTextChange(query: String?): Boolean = false

        })

    }

    override fun onShowLoading() {
        ui.pb_team.visible()
        ui.rv_team.gone()
        ui.include_no_connection.gone()
    }

    override fun onSuccessFetchData(teamList: List<Team>) {
        ui.rv_team.layoutManager = LinearLayoutManager(activity)
        ui.rv_team.adapter = TeamAdapter(activity!!, teamList)
    }

    override fun onFailureFetchData() {
        ui.pb_team.gone()
        ui.rv_team.gone()
        ui.include_no_connection.visible()
    }

    override fun onHideLoading() {
        ui.pb_team.gone()
        ui.rv_team.visible()
        ui.include_no_connection.gone()
    }

}