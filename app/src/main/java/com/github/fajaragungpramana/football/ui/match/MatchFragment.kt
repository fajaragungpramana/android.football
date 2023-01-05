package com.github.fajaragungpramana.football.ui.match

import android.os.Bundle
import android.view.ViewGroup
import com.github.fajaragungpramana.football.common.app.AppFragment
import com.github.fajaragungpramana.football.databinding.FragmentMatchBinding

class MatchFragment : AppFragment<FragmentMatchBinding>() {

    override fun onViewBinding(container: ViewGroup?) =
        FragmentMatchBinding.inflate(layoutInflater, container, false)

    override fun onCreated(savedInstanceState: Bundle?) {

    }

}