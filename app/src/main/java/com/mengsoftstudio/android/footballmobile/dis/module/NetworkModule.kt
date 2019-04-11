package com.mengsoftstudio.android.footballmobile.dis.module

import com.mengsoftstudio.android.footballmobile.databases.rests.ApiRepository
import com.mengsoftstudio.android.footballmobile.databases.rests.ApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class NetworkModule {

    @Provides
    @Reusable
    fun apiRepository(): ApiRepository =
            ApiService.create()

}