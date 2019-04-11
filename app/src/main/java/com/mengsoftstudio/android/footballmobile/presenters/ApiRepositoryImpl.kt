package com.mengsoftstudio.android.footballmobile.presenters

import com.mengsoftstudio.android.footballmobile.databases.rests.ApiRepository
import com.mengsoftstudio.android.footballmobile.models.response.Response
import io.reactivex.Flowable
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val apiRepository: ApiRepository) {

    fun getEventsNextMatch(id: String): Flowable<Response.MatchResponse> =
            apiRepository.eventsNextMatch(id)

    fun getEventsLastMatch(id: String): Flowable<Response.MatchResponse> =
            apiRepository.eventsLastMatch(id)

    fun getAllTeamLeague(l: String): Flowable<Response.TeamResponse> =
            apiRepository.allTeamLeague(l)

    fun getTeamBadge(id: String?): Flowable<Response.BadgeResponse> =
            apiRepository.teamBadge(id)

    fun getSearchMatch(query: String): Flowable<Response.SearchMatchResponse> =
            apiRepository.searchMatch(query)

    fun getTeamPlayer(id: String): Flowable<Response.PlayerResponse> =
            apiRepository.teamPlayer(id)

    fun getSearchTeam(query: String): Flowable<Response.SearchTeamResponse> =
            apiRepository.searchTeam(query)

    fun getMatchFavorite(id: String): Flowable<Response.MatchFavoriteResponse> =
            apiRepository.matchFavorite(id)

    fun getTeamFavorite(id: String): Flowable<Response.TeamFavoriteResponse> =
            apiRepository.teamFavorite(id)

}