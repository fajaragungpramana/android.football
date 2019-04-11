package com.mengsoftstudio.android.footballmobile.views.fragment.module

import com.mengsoftstudio.android.footballmobile.contracts.TeamFavoriteContract
import com.mengsoftstudio.android.footballmobile.dis.scope.ActivityScope
import com.mengsoftstudio.android.footballmobile.presenters.TeamFavoritePresenter
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.TeamFavoriteTab
import dagger.Binds
import dagger.Module

@Module
abstract class TeamFavoriteTabModule {

    @ActivityScope
    @Binds
    abstract fun provideView(teamFavoriteTab: TeamFavoriteTab): TeamFavoriteContract.View

    @ActivityScope
    @Binds
    abstract fun providePresenter(teamFavoritePresenter: TeamFavoritePresenter): TeamFavoriteContract.Presenter

}