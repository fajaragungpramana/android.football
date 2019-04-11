package com.mengsoftstudio.android.footballmobile.views.fragment.module

import com.mengsoftstudio.android.footballmobile.contracts.PlayerContract
import com.mengsoftstudio.android.footballmobile.dis.scope.ActivityScope
import com.mengsoftstudio.android.footballmobile.presenters.PlayerPresenter
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.PlayerOverviewTab
import dagger.Binds
import dagger.Module

@Module
abstract class PlayerOverviewTabModule {

    @ActivityScope
    @Binds
    abstract fun provideView(playerOverviewTab: PlayerOverviewTab): PlayerContract.View

    @ActivityScope
    @Binds
    abstract fun providePresenter(playerPresenter: PlayerPresenter): PlayerContract.Presenter

}