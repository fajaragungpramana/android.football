package com.mengsoftstudio.android.footballmobile.views.activity.module

import android.content.Context
import com.mengsoftstudio.android.footballmobile.dis.scope.ActivityScope
import com.mengsoftstudio.android.footballmobile.presenters.LocalRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class TeamDetailActivityModule {

    @ActivityScope
    @Provides
    fun provideLocalRepository(context: Context): LocalRepositoryImpl =
            LocalRepositoryImpl(context)

}