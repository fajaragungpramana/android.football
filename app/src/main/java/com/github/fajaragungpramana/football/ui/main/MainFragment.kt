package com.github.fajaragungpramana.football.ui.main

import android.os.Bundle
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.github.fajaragungpramana.football.R
import com.github.fajaragungpramana.football.common.app.AppFragment
import com.github.fajaragungpramana.football.databinding.FragmentMainBinding

class MainFragment : AppFragment<FragmentMainBinding>() {

    override fun onViewBinding(container: ViewGroup?) =
        FragmentMainBinding.inflate(layoutInflater, container, false)

    override fun onCreated(savedInstanceState: Bundle?) {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.fcv_bnv) as NavHostFragment
        viewBinding.bnvMain.setupWithNavController(navHostFragment.navController)
    }

}