package com.mengsoftstudio.android.footballmobile.views.fragment.module

import com.mengsoftstudio.android.footballmobile.contracts.MatchFavoriteContract
import com.mengsoftstudio.android.footballmobile.dis.scope.ActivityScope
import com.mengsoftstudio.android.footballmobile.presenters.MatchFavoritePresenter
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.MatchFavoriteTab
import dagger.Binds
import dagger.Module

@Module
abstract class MatchFavoriteTabModule {

    @ActivityScope
    @Binds
    abstract fun provideView(matchFavoriteTab: MatchFavoriteTab): MatchFavoriteContract.View

    @ActivityScope
    @Binds
    abstract fun providePresenter(matchFavoritePresenter: MatchFavoritePresenter): MatchFavoriteContract.Presenter

}