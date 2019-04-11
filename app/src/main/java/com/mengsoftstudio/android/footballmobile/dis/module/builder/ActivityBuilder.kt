package com.mengsoftstudio.android.footballmobile.dis.module.builder

import com.mengsoftstudio.android.footballmobile.dis.scope.ActivityScope
import com.mengsoftstudio.android.footballmobile.views.activity.MatchDetailActivity
import com.mengsoftstudio.android.footballmobile.views.activity.SearchMatchActivity
import com.mengsoftstudio.android.footballmobile.views.activity.SearchTeamActivity
import com.mengsoftstudio.android.footballmobile.views.activity.TeamDetailActivity
import com.mengsoftstudio.android.footballmobile.views.activity.module.*
import com.mengsoftstudio.android.footballmobile.views.fragment.TeamsFragment
import com.mengsoftstudio.android.footballmobile.views.fragment.module.*
import com.mengsoftstudio.android.footballmobile.views.fragment.tab.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [NextMatchTabModule::class])
    abstract fun provideNextMatchTab(): NextMatchTab

    @ActivityScope
    @ContributesAndroidInjector(modules = [LastMatchTabModule::class])
    abstract fun provideLastMatchTab(): LastMatchTab

    @ActivityScope
    @ContributesAndroidInjector(modules = [TeamsFragmentModule::class])
    abstract fun provideTeamsFragment(): TeamsFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [MatchDetailActivityModule::class])
    abstract fun provideMatchDetailActivity(): MatchDetailActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SearchMatchActivityModule::class])
    abstract fun provideSearchMatchActivity(): SearchMatchActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [PlayerOverviewTabModule::class])
    abstract fun providePlayerOverviewTab(): PlayerOverviewTab

    @ActivityScope
    @ContributesAndroidInjector(modules = [SearchTeamActivityModule::class])
    abstract fun provideSearchTeamActivity(): SearchTeamActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MatchFavoriteTabModule::class])
    abstract fun provideMatchFavoriteTab(): MatchFavoriteTab

    @ActivityScope
    @ContributesAndroidInjector(modules = [TeamFavoriteTabModule::class])
    abstract fun provideTeamFavoriteTab(): TeamFavoriteTab

    @ActivityScope
    @ContributesAndroidInjector(modules = [TeamDetailActivityModule::class])
    abstract fun provideTeamDetailActivity(): TeamDetailActivity

}