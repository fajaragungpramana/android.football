package com.mengsoftstudio.android.footballmobile.databases.rests

import com.mengsoftstudio.android.footballmobile.models.response.Response
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRepository {

    @GET("eventsnextleague.php")
    fun eventsNextMatch(@Query("id") id: String): Flowable<Response.MatchResponse>

    @GET("eventspastleague.php")
    fun eventsLastMatch(@Query("id") id: String): Flowable<Response.MatchResponse>

    @GET("search_all_teams.php")
    fun allTeamLeague(@Query("l") l: String): Flowable<Response.TeamResponse>

    @GET("lookupteam.php")
    fun teamBadge(@Query("id") id: String?): Flowable<Response.BadgeResponse>

    @GET("searchevents.php")
    fun searchMatch(@Query("e") query: String): Flowable<Response.SearchMatchResponse>

    @GET("lookup_all_players.php")
    fun teamPlayer(@Query("id") id: String): Flowable<Response.PlayerResponse>

    @GET("searchteams.php")
    fun searchTeam(@Query("t") query: String): Flowable<Response.SearchTeamResponse>

    @GET("lookupevent.php")
    fun matchFavorite(@Query("id") id: String): Flowable<Response.MatchFavoriteResponse>

    @GET("lookupteam.php")
    fun teamFavorite(@Query("id") id: String): Flowable<Response.TeamFavoriteResponse>

}