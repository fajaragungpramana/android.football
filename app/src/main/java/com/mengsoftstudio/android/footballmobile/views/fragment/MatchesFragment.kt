package com.mengsoftstudio.android.footballmobile.views.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.SearchView
import android.view.*
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import com.mengsoftstudio.android.footballmobile.views.activity.SearchMatchActivity
import com.mengsoftstudio.android.footballmobile.views.adapter.TabAdapter
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.LastMatchTab
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.NextMatchTab
import kotlinx.android.synthetic.main.fragment_matches.view.*
import org.jetbrains.anko.intentFor

class MatchesFragment : Fragment() {

    private lateinit var ui: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = inflater.inflate(R.layout.fragment_matches, container, false)
        setHasOptionsMenu(true)

        val tabAdapter = TabAdapter(childFragmentManager)
        tabAdapter.setTab(NextMatchTab())
        tabAdapter.setTab(LastMatchTab())

        ui.vp_match.adapter = tabAdapter

        ui.vp_match.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(p0: Int) {}

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {}

            override fun onPageSelected(position: Int) {

                when( position ) {

                    0 -> {

                        ui.btn_next_match.setTextColor( resources.getColor(R.color.colorPrimaryText) )
                        ui.btn_last_match.setTextColor( resources.getColor(R.color.colorSecondaryText) )

                    }

                    1 -> {

                        ui.btn_next_match.setTextColor( resources.getColor(R.color.colorSecondaryText) )
                        ui.btn_last_match.setTextColor( resources.getColor(R.color.colorPrimaryText) )

                    }

                }

            }

        })

        ui.btn_next_match.setOnClickListener { ui.vp_match.currentItem = 0 }
        ui.btn_last_match.setOnClickListener { ui.vp_match.currentItem = 1 }

        return ui
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        val search = menu?.findItem(R.id.action_search)?.actionView as SearchView
        search.queryHint = getString(R.string.query_hint_search_match)
        search.isSubmitButtonEnabled = true

        search.setOnQueryTextListener( object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {

                activity?.startActivity(activity?.intentFor<SearchMatchActivity>(Constant.INTENT_TAG_SEARCH_MATCH to query)
                        ?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        ?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))

                return true
            }

            override fun onQueryTextChange(query: String?): Boolean =  false

        })

    }

}