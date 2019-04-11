package com.mengsoftstudio.android.footballmobile.views.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import kotlinx.android.synthetic.main.activity_loading.*
import org.jetbrains.anko.intentFor

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        iv_logo_loading.startAnimation( AnimationUtils.loadAnimation(this@LoadingActivity, R.anim.bounce) )
        tv_slogan.startAnimation( AnimationUtils.loadAnimation(this@LoadingActivity, R.anim.translation_y) )

        Handler().postDelayed({

            startActivity(intentFor<MainActivity>()
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))

            finish()

        }, Constant.LOADING_TIME)

    }

}
