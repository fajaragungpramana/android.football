package com.mengsoftstudio.android.footballmobile.views.activity

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.contracts.MatchDetailContract
import com.mengsoftstudio.android.footballmobile.extensions.gone
import com.mengsoftstudio.android.footballmobile.extensions.visible
import com.mengsoftstudio.android.footballmobile.models.Badge
import com.mengsoftstudio.android.footballmobile.models.Match
import com.mengsoftstudio.android.footballmobile.models.MatchFavorite
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import com.mengsoftstudio.android.footballmobile.presenters.MatchDetailPresenter
import com.mengsoftstudio.android.footballmobile.views.adapter.TabAdapter
import com.mengsoftstudio.android.footballmobile.views.base.BaseActivity
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.LineupOverviewTab
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.MatchOverviewTab
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_match_detail.*
import kotlinx.android.synthetic.main.support_no_connection.*
import kotlinx.android.synthetic.main.support_toolbar.*
import org.jetbrains.anko.toast
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MatchDetailActivity : BaseActivity(), MatchDetailContract.View {

    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null

    private lateinit var match: Match

    @Inject lateinit var presenter: MatchDetailPresenter

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_match_detail)

        setSupportActionBar( support_toolbar )
        supportActionBar?.title = getString(R.string.title_football_match_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled( true )

        match = intent.getParcelableExtra(Constant.INTENT_TAG_MATCH)

        presenter.hasMatchFavorite( match.idEvent!! )

        onRequest()

        btn_try_gain.setOnClickListener {
            onRequest()
        }

        val tabAdapter = TabAdapter(supportFragmentManager)
        tabAdapter.setTab(MatchOverviewTab(), getString(R.string.title_match_overview))
        tabAdapter.setTab(LineupOverviewTab(), getString(R.string.title_lineup_overview))

        vp_match_detail.adapter = tabAdapter
        tl_match_detail.setupWithViewPager( vp_match_detail )

    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDestroyPresenter()

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
                    presenter.setMatchFavorite( match.idEvent!! )
                    toast(getString(R.string.toast_added_to_favorites))
                } else {
                    presenter.removeMatchFavorite( match.idEvent!! )
                    toast(getString(R.string.toast_remove_from_favorites))
                }

                isFavorite = !isFavorite
                setFavorites()

                true
            }

            else -> super.onOptionsItemSelected(item)

        }

    override fun onShowLoading() {
        pb_match_detail.visible()
        abl_match_detail.gone()
        nsv_match_detail.gone()
        include_no_connection.gone()
    }

    override fun setHomeBadge(badge: Badge) {
        Picasso.get().load(badge.teamBadge).into(iv_home_badge)
    }

    override fun setAwayBadge(badge: Badge) {
        Picasso.get().load(badge.teamBadge).into(iv_away_badge)
    }

    override fun onFailureFetchData() {
        pb_match_detail.gone()
        abl_match_detail.gone()
        nsv_match_detail.gone()
        include_no_connection.visible()
    }

    override fun onHideLoading() {
        pb_match_detail.gone()
        abl_match_detail.visible()
        nsv_match_detail.visible()
        include_no_connection.gone()

        updateUi()
    }

    override fun hasMatchFavorite(matchFavoriteList: List<MatchFavorite>) {
        if(!matchFavoriteList.isEmpty()) isFavorite = true
    }

    private fun onRequest() {
        presenter.getHomeBadge(match.idHome)
        presenter.getAwayBadge(match.idAway)
    }

    private fun updateUi() {

        try {

            if (match.dateMatch == null || match.timeMatch == null) {
                tv_date_match.text = getString(R.string.negative)
                tv_time_match.text = getString(R.string.negative)
            } else if (match.dateMatch.equals("") || match.timeMatch.equals("")) {
                tv_date_match.text = getString(R.string.negative)
                tv_time_match.text = getString(R.string.negative)
            } else {
                tv_date_match.text = SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault())
                    .format( SimpleDateFormat("yyyy-MM-d", Locale.US).parse(match.dateMatch) )

                tv_time_match.text = SimpleDateFormat("HH:mm", Locale.getDefault())
                    .format( SimpleDateFormat("HH:mm:ssZ", Locale.US).parse(match.timeMatch) )
            }

        } catch (exc: ParseException) {
            exc.printStackTrace()
        }

        if (match.homeTeam == null || match.awayTeam == null) {
            tv_home_team.text = getString(R.string.negative)
            tv_away_team.text = getString(R.string.negative)
        } else if (match.homeTeam.equals("") || match.awayTeam.equals("")) {
            tv_home_team.text = getString(R.string.negative)
            tv_away_team.text = getString(R.string.negative)
        } else {
            tv_home_team.text = match.homeTeam
            tv_away_team.text = match.awayTeam
        }

        if (match.homeScore == null || match.awayScore == null) {
            tv_home_score.text = ""
            tv_away_score.text = ""
        } else if (match.homeScore.equals("") || match.awayScore.equals("")) {
            tv_home_score.text = ""
            tv_away_score.text = ""
        } else {
            tv_home_score.text = match.homeScore
            tv_away_score.text = match.awayScore
        }

        cv_view_match.startAnimation( AnimationUtils.loadAnimation(this@MatchDetailActivity, R.anim.bounce) )

    }

    private fun setFavorites() {
        if(isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_favorite)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_favorite)
    }

    fun getMatch(): Match = match

}