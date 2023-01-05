package com.github.fajaragungpramana.football.ui.main

import android.os.Bundle
import android.view.ViewGroup
import com.github.fajaragungpramana.football.common.app.AppFragment
import com.github.fajaragungpramana.football.databinding.FragmentMainBinding

class MainFragment : AppFragment<FragmentMainBinding>() {

    override fun onViewBinding(container: ViewGroup?) =
        FragmentMainBinding.inflate(layoutInflater, container, false)

    override fun onCreated(savedInstanceState: Bundle?) {

    }

}