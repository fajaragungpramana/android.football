package com.mengsoftstudio.android.footballmobile.dis.component

import android.app.Application
import com.mengsoftstudio.android.footballmobile.dis.App
import com.mengsoftstudio.android.footballmobile.dis.module.AppModule
import com.mengsoftstudio.android.footballmobile.dis.module.builder.ActivityBuilder
import com.mengsoftstudio.android.footballmobile.dis.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component( modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class
] )
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}