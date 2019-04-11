package com.mengsoftstudio.android.footballmobile.views.fragment.module

import com.mengsoftstudio.android.footballmobile.contracts.MatchContract
import com.mengsoftstudio.android.footballmobile.dis.scope.ActivityScope
import com.mengsoftstudio.android.footballmobile.presenters.MatchPresenter
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.LastMatchTab
import dagger.Binds
import dagger.Module

@Module
abstract class LastMatchTabModule {

    @ActivityScope
    @Binds
    abstract fun provideView(lastMatchTab: LastMatchTab): MatchContract.View

    @ActivityScope
    @Binds
    abstract fun providePresenter(matchPresenter: MatchPresenter): MatchContract.Presenter

}