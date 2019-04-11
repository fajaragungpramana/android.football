package com.mengsoftstudio.android.footballmobile.views.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.contracts.SearchMatchContract
import com.mengsoftstudio.android.footballmobile.extensions.gone
import com.mengsoftstudio.android.footballmobile.extensions.visible
import com.mengsoftstudio.android.footballmobile.models.Match
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import com.mengsoftstudio.android.footballmobile.presenters.SearchMatchPresenter
import com.mengsoftstudio.android.footballmobile.views.adapter.MatchAdapter
import com.mengsoftstudio.android.footballmobile.views.base.BaseActivity
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.support_toolbar.*
import javax.inject.Inject

class SearchMatchActivity : BaseActivity(), SearchMatchContract.View {

    @Inject
    lateinit var presenter: SearchMatchPresenter

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_search)

        RxJavaPlugins.setErrorHandler {}

        setSupportActionBar( support_toolbar )
        supportActionBar?.title = getString(R.string.toolbar_title_football_matches)
        supportActionBar?.setDisplayHomeAsUpEnabled( true )

        presenter.getSearchMatch( intent.getStringExtra(Constant.INTENT_TAG_SEARCH_MATCH) )

    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDestroyPresenter()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_main, menu)

        val search = menu?.findItem(R.id.action_search)?.actionView as SearchView
        search.queryHint = getString(R.string.query_hint_search_match)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean = false

            override fun onQueryTextChange(query: String): Boolean {

                presenter.getSearchMatch(query)

                return true
            }

        })

        return true
    }

    override fun onShowLoading() {
        rv_search.visible()
        rv_search.gone()
        include_no_connection.gone()
    }

    override fun onSuccessFetchData(matchList: List<Match>) {
        rv_search.layoutManager = LinearLayoutManager( this@SearchMatchActivity )
        rv_search.adapter = MatchAdapter(matchList, this@SearchMatchActivity)
    }

    override fun onFailureFetchData() {
        rv_search.gone()
        rv_search.gone()
        include_no_connection.visible()
    }

    override fun onHideLoading() {
        rv_search.gone()
        rv_search.visible()
        include_no_connection.gone()
    }

}