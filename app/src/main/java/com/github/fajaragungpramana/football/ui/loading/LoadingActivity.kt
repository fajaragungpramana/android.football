package com.github.fajaragungpramana.football.ui.loading

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.github.fajaragungpramana.football.common.app.AppActivity
import com.github.fajaragungpramana.football.databinding.ActivityLoadingBinding
import com.github.fajaragungpramana.football.ui.main.MainActivity

class LoadingActivity : AppActivity<ActivityLoadingBinding>() {

    override fun onViewBinding() = ActivityLoadingBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {
        Handler(mainLooper).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, TIME_DELAY)
    }

    private companion object {
        const val TIME_DELAY = 2000L
    }

}