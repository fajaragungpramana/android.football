package com.github.fajaragungpramana.football.ui

import android.os.Bundle
import com.github.fajaragungpramana.football.common.app.AppActivity
import com.github.fajaragungpramana.football.databinding.ActivityMainBinding

class MainActivity : AppActivity<ActivityMainBinding>() {

    override fun onViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {

    }

}