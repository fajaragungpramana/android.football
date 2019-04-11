package com.mengsoftstudio.android.footballmobile.views.activity.module

import com.mengsoftstudio.android.footballmobile.contracts.MatchDetailContract
import com.mengsoftstudio.android.footballmobile.dis.scope.ActivityScope
import com.mengsoftstudio.android.footballmobile.presenters.MatchDetailPresenter
import com.mengsoftstudio.android.footballmobile.views.activity.MatchDetailActivity
import dagger.Binds
import dagger.Module

@Module
abstract class MatchDetailActivityModule {

    @ActivityScope
    @Binds
    abstract fun provideView(matchDetailActivity: MatchDetailActivity): MatchDetailContract.View

    @ActivityScope
    @Binds
    abstract fun providePresenter(badgePresenter: MatchDetailPresenter): MatchDetailContract.Presenter

}