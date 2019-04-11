package com.mengsoftstudio.android.footballmobile.views.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.views.adapter.TabAdapter
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.MatchFavoriteTab
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.TeamFavoriteTab
import kotlinx.android.synthetic.main.fragment_favorites.view.*

class FavoritesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val ui = inflater.inflate(R.layout.fragment_favorites, container, false)

        val tabAdapter = TabAdapter(childFragmentManager)
        tabAdapter.setTab(MatchFavoriteTab(), getString(R.string.tab_title_match))
        tabAdapter.setTab(TeamFavoriteTab(), getString(R.string.tab_title_team))

        ui.vp_favorite.adapter = tabAdapter
        ui.tl_favorite.setupWithViewPager( ui.vp_favorite )

        return ui
    }

}