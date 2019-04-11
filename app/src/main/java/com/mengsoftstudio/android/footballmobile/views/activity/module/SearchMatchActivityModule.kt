package com.mengsoftstudio.android.footballmobile.views.activity.module

import com.mengsoftstudio.android.footballmobile.contracts.SearchMatchContract
import com.mengsoftstudio.android.footballmobile.dis.scope.ActivityScope
import com.mengsoftstudio.android.footballmobile.presenters.SearchMatchPresenter
import com.mengsoftstudio.android.footballmobile.views.activity.SearchMatchActivity
import dagger.Binds
import dagger.Module

@Module
abstract class SearchMatchActivityModule {

    @ActivityScope
    @Binds
    abstract fun provideView(searchMatchActivity: SearchMatchActivity): SearchMatchContract.View

    @ActivityScope
    @Binds
    abstract fun providePresenter(searchMatchPresenter: SearchMatchPresenter): SearchMatchContract.Presenter

}