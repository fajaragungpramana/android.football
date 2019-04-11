package com.mengsoftstudio.android.footballmobile.views.fragment.tab

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.models.Match
import com.mengsoftstudio.android.footballmobile.views.activity.MatchDetailActivity
import kotlinx.android.synthetic.main.tab_overview_match.view.*

class MatchOverviewTab : Fragment() {

    private lateinit var ui: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = inflater.inflate(R.layout.tab_overview_match, container, false)
        return ui
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val matchDetailActivity = activity as MatchDetailActivity
        updateUi( matchDetailActivity.getMatch() )

    }

    private fun updateUi(match: Match) {

        try {

            if (match.homeShot == null || match.awayShot == null) {
                ui.tv_home_shot.text = getString(R.string.text_zero)
                ui.tv_away_shot.text = getString(R.string.text_zero)
            } else if (match.homeShot.equals("") || match.awayShot.equals("")) {
                ui.tv_home_shot.text = getString(R.string.text_zero)
                ui.tv_away_shot.text = getString(R.string.text_zero)
            } else {
                ui.tv_home_shot.text = match.homeShot
                ui.tv_away_shot.text = match.awayShot
            }

            if (match.homeGoal == null || match.awayGoal == null) {
                ui.tv_home_goal.text = getString(R.string.negative)
                ui.tv_away_goal.text = getString(R.string.negative)
            } else if (match.homeGoal.equals("") || match.awayGoal.equals("")) {
                ui.tv_home_goal.text = getString(R.string.negative)
                ui.tv_away_goal.text = getString(R.string.negative)
            } else {
                ui.tv_home_goal.text = match.homeGoal
                ui.tv_away_goal.text = match.awayGoal
            }

            if (match.homeYellowCard == null || match.awayYellowCard == null) {
                ui.tv_home_yellow_card.text = getString(R.string.negative)
                ui.tv_away_yellow_card.text = getString(R.string.negative)
            } else if (match.homeYellowCard.equals("") || match.awayYellowCard.equals("")) {
                ui.tv_home_yellow_card.text = getString(R.string.negative)
                ui.tv_away_yellow_card.text = getString(R.string.negative)
            } else {
                ui.tv_home_yellow_card.text = match.homeYellowCard
                ui.tv_away_yellow_card.text = match.homeYellowCard
            }

            if(match.homeRedCard == null || match.awayRedCard == null) {
                ui.tv_home_red_card.text = getString(R.string.negative)
                ui.tv_away_red_card.text = getString(R.string.negative)
            } else if(match.homeRedCard.equals("") || match.awayRedCard.equals("")) {
                ui.tv_home_red_card.text = getString(R.string.negative)
                ui.tv_away_red_card.text = getString(R.string.negative)
            } else {
                ui.tv_home_red_card.text = match.homeRedCard
                ui.tv_away_red_card.text = match.homeRedCard
            }

        } catch (exc: Exception) {
            exc.printStackTrace()
        }

        ui.cv_view_shot.alpha = 0f
        ui.cv_view_shot.translationY = 500f
        ui.cv_view_shot.animate().alpha(1f).translationY(0f).setDuration(800).start()

        ui.cv_view_goal.alpha = 0f
        ui.cv_view_goal.translationY = 500f
        ui.cv_view_goal.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(300).start()

        ui.cv_view_yellow_card.alpha = 0f
        ui.cv_view_yellow_card.translationY = 500f
        ui.cv_view_yellow_card.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(600).start()

        ui.cv_view_red_card.alpha = 0f
        ui.cv_view_red_card.translationY = 500f
        ui.cv_view_red_card.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(900).start()

    }

}