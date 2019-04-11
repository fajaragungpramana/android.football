package com.mengsoftstudio.android.footballmobile.views.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this@BaseFragment)
        return onFragmentCreateView(inflater, container, savedInstanceState)
    }

    abstract fun onFragmentCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?

}