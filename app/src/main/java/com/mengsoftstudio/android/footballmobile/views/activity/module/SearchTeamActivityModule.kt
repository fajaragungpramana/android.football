package com.mengsoftstudio.android.footballmobile.views.activity.module

import com.mengsoftstudio.android.footballmobile.contracts.SearchTeamContract
import com.mengsoftstudio.android.footballmobile.dis.scope.ActivityScope
import com.mengsoftstudio.android.footballmobile.presenters.SearchTeamPresenter
import com.mengsoftstudio.android.footballmobile.views.activity.SearchTeamActivity
import dagger.Binds
import dagger.Module

@Module
abstract class SearchTeamActivityModule {

    @ActivityScope
    @Binds
    abstract fun provideView(searchTeamActivity: SearchTeamActivity): SearchTeamContract.View

    @ActivityScope
    @Binds
    abstract fun providePresenter(searchTeamPresenter: SearchTeamPresenter): SearchTeamContract.Presenter

}
