package com.mengsoftstudio.android.footballmobile.views.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.contracts.SearchTeamContract
import com.mengsoftstudio.android.footballmobile.extensions.gone
import com.mengsoftstudio.android.footballmobile.extensions.visible
import com.mengsoftstudio.android.footballmobile.models.Team
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import com.mengsoftstudio.android.footballmobile.presenters.SearchTeamPresenter
import com.mengsoftstudio.android.footballmobile.views.adapter.TeamAdapter
import com.mengsoftstudio.android.footballmobile.views.base.BaseActivity
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.support_toolbar.*
import javax.inject.Inject

class SearchTeamActivity : BaseActivity(), SearchTeamContract.View {

    @Inject
    lateinit var presenter: SearchTeamPresenter

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_search)

        RxJavaPlugins.setErrorHandler {}

        setSupportActionBar( support_toolbar )
        supportActionBar?.title = getString(R.string.toolbar_title_football_teams)
        supportActionBar?.setDisplayHomeAsUpEnabled( true )

        presenter.getSearchTeam( intent.getStringExtra(Constant.INTENT_TAG_SEARCH_TEAM) )

    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDestroyPresenter()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_main, menu)

        val search = menu?.findItem(R.id.action_search)?.actionView as SearchView
        search.queryHint = getString(R.string.query_hint_search_team)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean = false

            override fun onQueryTextChange(query: String): Boolean {

                presenter.getSearchTeam(query)

                return true
            }

        })

        return true
    }

    override fun onShowLoading() {
        pb_search.visible()
        rv_search.gone()
        include_no_connection.gone()
    }

    override fun onSuccessFetchData(teamList: List<Team>) {
        rv_search.layoutManager = LinearLayoutManager( this@SearchTeamActivity )
        rv_search.adapter = TeamAdapter(this@SearchTeamActivity, teamList)
    }

    override fun onFailureFetchData() {
        pb_search.gone()
        rv_search.gone()
        include_no_connection.visible()
    }

    override fun onHideLoading() {
        pb_search.gone()
        rv_search.visible()
        include_no_connection.gone()
    }

}