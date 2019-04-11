package com.mengsoftstudio.android.footballmobile.views.fragment.tab

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.models.Match
import com.mengsoftstudio.android.footballmobile.views.activity.MatchDetailActivity
import kotlinx.android.synthetic.main.tab_overview_lineup.view.*

class LineupOverviewTab : Fragment() {

    private lateinit var ui: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = inflater.inflate(R.layout.tab_overview_lineup, container, false)

        val matchDetailActivity = activity as MatchDetailActivity
        updateUi( matchDetailActivity.getMatch() )

        return ui
    }

    private fun updateUi(match: Match) {

        try {

            if (match.homeKeeper == null || match.awayKeeper == null) {
                ui.tv_home_keeper.text = getString(R.string.negative)
                ui.tv_away_keeper.text = getString(R.string.negative)
            } else if (match.homeKeeper == "" || match.awayKeeper == "") {
                ui.tv_home_keeper.text = getString(R.string.negative)
                ui.tv_away_keeper.text = getString(R.string.negative)
            } else {
                ui.tv_home_keeper.text = match.homeKeeper
                ui.tv_away_keeper.text = match.awayKeeper
            }

            if (match.homeDefense == null || match.awayDefense == null) {
                ui.tv_home_defense.text = getString(R.string.negative)
                ui.tv_away_defense.text = getString(R.string.negative)
            } else if (match.homeDefense == "" || match.awayDefense == "") {
                ui.tv_home_defense.text = getString(R.string.negative)
                ui.tv_away_defense.text = getString(R.string.negative)
            } else {
                ui.tv_home_defense.text = match.homeDefense
                ui.tv_away_defense.text = match.awayDefense
            }

            if (match.homeMidfield == null || match.awayMidfield == null) {
                ui.tv_home_midfield.text = getString(R.string.negative)
                ui.tv_away_midfield.text = getString(R.string.negative)
            } else if (match.homeMidfield == "" || match.awayMidfield == "") {
                ui.tv_home_midfield.text = getString(R.string.negative)
                ui.tv_away_midfield.text = getString(R.string.negative)
            } else {
                ui.tv_home_midfield.text = match.homeMidfield
                ui.tv_away_midfield.text = match.awayMidfield
            }

            if (match.homeForward == null || match.awayForward == null) {
                ui.tv_home_forward.text = getString(R.string.negative)
                ui.tv_away_forward.text = getString(R.string.negative)
            } else if (match.homeForward == "" || match.awayForward == "") {
                ui.tv_home_forward.text = getString(R.string.negative)
                ui.tv_away_forward.text = getString(R.string.negative)
            } else {
                ui.tv_home_forward.text = match.homeForward
                ui.tv_away_forward.text = match.awayForward
            }

            if (match.homeSubstitute == null || match.awaySubstitute == null) {
                ui.tv_home_subtitute.text = getString(R.string.negative)
                ui.tv_away_subtitute.text = getString(R.string.negative)
            } else if (match.homeSubstitute == "" || match.awaySubstitute == "") {
                ui.tv_home_subtitute.text = getString(R.string.negative)
                ui.tv_away_subtitute.text = getString(R.string.negative)
            } else {
                ui.tv_home_subtitute.text = match.homeSubstitute
                ui.tv_away_subtitute.text = match.awaySubstitute
            }

        } catch (exc: Exception) {
            exc.printStackTrace()
        }

        ui.cv_view_keeper.alpha = 0f
        ui.cv_view_keeper.translationY = 500f
        ui.cv_view_keeper.animate().alpha(1f).translationY(0f).setDuration(800).start()

        ui.cv_view_defense.alpha = 0f
        ui.cv_view_defense.translationY = 500f
        ui.cv_view_defense.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(300).start()

        ui.cv_view_midfield.alpha = 0f
        ui.cv_view_midfield.translationY = 500f
        ui.cv_view_midfield.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(600).start()

        ui.cv_view_forward.alpha = 0f
        ui.cv_view_forward.translationY = 500f
        ui.cv_view_forward.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(900).start()

        ui.cv_view_subtitute.alpha = 0f
        ui.cv_view_subtitute.translationY = 500f
        ui.cv_view_subtitute.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(1200).start()

    }

}