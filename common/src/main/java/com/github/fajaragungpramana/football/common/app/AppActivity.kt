package com.github.fajaragungpramana.football.common.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.github.fajaragungpramana.football.common.contract.AppObserver

abstract class AppActivity<VB : ViewBinding> : AppCompatActivity() {

    private lateinit var mViewBinding: VB
    protected val viewBinding: VB
        get() = mViewBinding

    protected abstract fun onViewBinding(): VB

    protected abstract fun onCreated(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = onViewBinding()
        setContentView(viewBinding.root)

        onCreated(savedInstanceState)

        if (this is AppObserver) onStateObserver()
    }

}