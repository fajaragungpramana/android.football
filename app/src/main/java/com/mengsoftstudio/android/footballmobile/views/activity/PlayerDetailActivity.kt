package com.mengsoftstudio.android.footballmobile.views.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.models.Player
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_player_detail.*
import kotlinx.android.synthetic.main.support_toolbar.*

class PlayerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)

        setSupportActionBar( support_toolbar )
        supportActionBar?.title = getString(R.string.toolbar_title_player_detail)

        val player = intent.getParcelableExtra(Constant.INTENT_TAG_PLAYER) as Player

        updateUi( player )

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_detail, menu)
        menu?.findItem(R.id.action_favorite)?.isVisible = false

        return true
    }

    @SuppressLint("SetTextI18n")
    private fun updateUi(player: Player) {

        if(player.playerPic == null)
            iv_player.setImageResource(R.drawable.ic_no_player)
        else
            Picasso.get().load(player.playerPic).into(iv_player)

        tv_player_name.text = player.playerName
        tv_player_position.text = player.playerPosition

        tv_player_birth_loc.text = "${getString(R.string.assigment)} ${player.playerBirthLoc}"
        tv_player_club.text = "${getString(R.string.assigment)} ${player.playerTeam}"
        tv_player_date_born.text = "${getString(R.string.assigment)} ${player.playerDateBorn}"

        tv_player_date_signed.text = "${getString(R.string.assigment)} ${player.playerDateSigned}"
        tv_player_gender.text = "${getString(R.string.assigment)} ${player.playerGender}"
        tv_player_height.text = "${getString(R.string.assigment)} ${player.playerHeight} ${getString(R.string.m)}"

        tv_player_nationality.text = "${getString(R.string.assigment)} ${player.playerNationality}"
        tv_player_signing.text = "${getString(R.string.assigment)} ${player.playerSigning}"
        tv_player_weight.text = "${getString(R.string.assigment)} ${player.playerWeight} ${getString(R.string.kg)}"

        if(player.playerFansArt == null)
            iv_player_fans_art.setImageResource(R.drawable.ic_broken_image)
        else
            Picasso.get().load(player.playerFansArt).into(iv_player_fans_art)

        tv_player_history.text = player.playerDesc

        cv_view_player.alpha = 0f
        cv_view_player.translationY = 500f
        cv_view_player.animate().alpha(1f).translationY(0f).setDuration(800).start()

        cv_view_other_info.alpha = 0f
        cv_view_other_info.translationY = 500f
        cv_view_other_info.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(300).start()

        cv_view_history.alpha = 0f
        cv_view_history.translationY = 500f
        cv_view_history.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(600).start()

    }

}