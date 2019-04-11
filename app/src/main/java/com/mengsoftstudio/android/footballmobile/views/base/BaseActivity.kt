package com.mengsoftstudio.android.footballmobile.views.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this@BaseActivity)
        super.onCreate(savedInstanceState)

        onActivityCreate(savedInstanceState)

    }

    abstract fun onActivityCreate(savedInstanceState: Bundle?)

}