package com.github.fajaragungpramana.football.ui.team

import android.os.Bundle
import android.view.ViewGroup
import com.github.fajaragungpramana.football.common.app.AppFragment
import com.github.fajaragungpramana.football.databinding.FragmentTeamBinding

class TeamFragment : AppFragment<FragmentTeamBinding>() {

    override fun onViewBinding(container: ViewGroup?) =
        FragmentTeamBinding.inflate(layoutInflater, container, false)

    override fun onCreated(savedInstanceState: Bundle?) {

    }

}