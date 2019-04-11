package com.mengsoftstudio.android.footballmobile.views.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.models.Team
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import com.mengsoftstudio.android.footballmobile.views.activity.TeamDetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_team.view.*
import org.jetbrains.anko.intentFor

class TeamAdapter(private val context: Context, private val teamList: List<Team>) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): TeamAdapter.ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_team, parent, false))

    override fun getItemCount(): Int =
            teamList.size

    override fun onBindViewHolder(viewHolder: TeamAdapter.ViewHolder, position: Int) {
        viewHolder.bindTeam(teamList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindTeam(team: Team) {

            Picasso.get().load(team.teamBadge).into(itemView.img_team_badge)
            itemView.tv_team_name.text = team.teamName
            itemView.tv_team_stadium.text = team.teamStadium

            itemView.setOnClickListener {

                context.startActivity(context.intentFor<TeamDetailActivity>(Constant.INTENT_TAG_TEAM to team)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))

            }

        }

    }

}