package com.mengsoftstudio.android.footballmobile.dis.module

import android.app.Application
import android.content.Context
import com.mengsoftstudio.android.footballmobile.dis.scope.ApplicationContext
import com.mengsoftstudio.android.footballmobile.dis.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module(includes = [
    NetworkModule::class
])
class AppModule {

    @ApplicationScope
    @Provides
    @ApplicationContext
    fun provideApplication(application: Application): Application =
            application

    @ApplicationScope
    @Provides
    fun provideContext(@ApplicationContext application: Application): Context =
            application

}