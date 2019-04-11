package com.mengsoftstudio.android.footballmobile.views.fragment.module

import com.mengsoftstudio.android.footballmobile.contracts.TeamContract
import com.mengsoftstudio.android.footballmobile.dis.scope.ActivityScope
import com.mengsoftstudio.android.footballmobile.presenters.TeamPresenter
import com.mengsoftstudio.android.footballmobile.views.fragment.TeamsFragment
import dagger.Binds
import dagger.Module

@Module
abstract class TeamsFragmentModule {

    @ActivityScope
    @Binds
    abstract fun provideView(teamsFragment: TeamsFragment): TeamContract.View

    @ActivityScope
    @Binds
    abstract fun providePresenter(teamPresenter: TeamPresenter): TeamContract.Presenter

}