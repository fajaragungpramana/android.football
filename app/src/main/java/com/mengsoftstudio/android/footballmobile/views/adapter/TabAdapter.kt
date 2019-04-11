package com.mengsoftstudio.android.footballmobile.views.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragmentList = arrayListOf<Fragment>()
    private val titleList = arrayListOf<String>()

    override fun getItem(position: Int): Fragment =
            fragmentList[position]

    override fun getCount(): Int =
            fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? =
            titleList[position]

    fun setTab(fragment: Fragment) {
        fragmentList.add(fragment)
    }

    fun setTab(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }

}