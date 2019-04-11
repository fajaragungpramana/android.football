package com.mengsoftstudio.android.footballmobile.views.fragment.tab

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.views.activity.TeamDetailActivity
import kotlinx.android.synthetic.main.tab_overview_team.view.*

class TeamOverviewTab : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val ui = inflater.inflate(R.layout.tab_overview_team, container, false)

        val teamDetailActivity = activity as TeamDetailActivity

        ui.tv_team_overview.text = teamDetailActivity.getTeam().teamDesc

        return ui
    }

}