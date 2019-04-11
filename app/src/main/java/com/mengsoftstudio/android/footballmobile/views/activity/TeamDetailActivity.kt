package com.mengsoftstudio.android.footballmobile.views.activity

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.models.Team
import com.mengsoftstudio.android.footballmobile.models.TeamFavorite
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import com.mengsoftstudio.android.footballmobile.presenters.LocalRepositoryImpl
import com.mengsoftstudio.android.footballmobile.views.adapter.TabAdapter
import com.mengsoftstudio.android.footballmobile.views.base.BaseActivity
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.PlayerOverviewTab
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.TeamOverviewTab
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_team_detail.*
import kotlinx.android.synthetic.main.support_toolbar.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class TeamDetailActivity : BaseActivity() {

    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null

    private lateinit var team: Team

    @Inject lateinit var localRepositoryImpl: LocalRepositoryImpl

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_team_detail)

        setSupportActionBar( support_toolbar )
        supportActionBar?.title = getString(R.string.toolbar_title_football_team_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled( true )

        team = intent.getParcelableExtra(Constant.INTENT_TAG_TEAM)

        updateUi( team )

        val tabAdapter = TabAdapter( supportFragmentManager )
        tabAdapter.setTab(TeamOverviewTab(), getString(R.string.tab_title_team_overview))
        tabAdapter.setTab(PlayerOverviewTab(), getString(R.string.tab_title_player_overview))

        vp_team_detail.adapter = tabAdapter
        tl_team_detail.setupWithViewPager( vp_team_detail )

        hasTeamFavorite( localRepositoryImpl.hasTeamFavorite(team.idTeam!!) )

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_detail, menu)
        menuItem = menu

        setFavorites()

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =

        when(item?.itemId) {

            R.id.action_favorite -> {

                if(!isFavorite) {
                    localRepositoryImpl.setTeamFavorite(team.idTeam!!)
                    toast(getString(R.string.toast_added_to_favorites))
                } else {
                    localRepositoryImpl.removeTeamFavorite(team.idTeam!!)
                    toast(getString(R.string.toast_remove_from_favorites))
                }

                isFavorite = !isFavorite
                setFavorites()

                true

            }

            else -> super.onOptionsItemSelected(item)

        }

    private fun updateUi(team: Team) {

        Picasso.get().load(team.teamBadge).into(iv_team)
        tv_team_name.text = team.teamName
        tv_team_formed.text = team.teamFormedYear
        tv_team_stadium.text = team.teamStadium

    }

    private fun hasTeamFavorite(teamFavoriteList: List<TeamFavorite>) {
        if(!teamFavoriteList.isEmpty()) isFavorite = true
    }

    private fun setFavorites() {
        if(isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_favorite)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_favorite)
    }

    fun getTeam(): Team = team

}