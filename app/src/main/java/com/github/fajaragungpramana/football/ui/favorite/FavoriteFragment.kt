package com.github.fajaragungpramana.football.ui.favorite

import android.os.Bundle
import android.view.ViewGroup
import com.github.fajaragungpramana.football.common.app.AppFragment
import com.github.fajaragungpramana.football.databinding.FragmentFavoriteBinding

class FavoriteFragment : AppFragment<FragmentFavoriteBinding>() {

    override fun onViewBinding(container: ViewGroup?) =
        FragmentFavoriteBinding.inflate(layoutInflater, container, false)

    override fun onCreated(savedInstanceState: Bundle?) {

    }

}