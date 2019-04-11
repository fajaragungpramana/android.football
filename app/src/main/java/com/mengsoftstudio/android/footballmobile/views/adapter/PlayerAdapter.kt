package com.mengsoftstudio.android.footballmobile.views.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.models.Player
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import com.mengsoftstudio.android.footballmobile.views.activity.PlayerDetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_player.view.*
import org.jetbrains.anko.intentFor

class PlayerAdapter(private val context: Context,
                    private val playerList: List<Player>) : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_player, parent, false))

    override fun getItemCount(): Int =
            playerList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindPlayer( playerList[position] )
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindPlayer(player: Player) {

            if(player.playerPic == null) {
                itemView.iv_player.setImageResource( R.drawable.ic_no_player )
            } else {
                Picasso.get().load(player.playerPic).into(itemView.iv_player)
            }

            itemView.tv_player_name.text = player.playerName
            itemView.tv_player_position.text = player.playerPosition

            itemView.setOnClickListener {

                context.startActivity(context.intentFor<PlayerDetailActivity>(Constant.INTENT_TAG_PLAYER to player)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))

            }

        }

    }

}