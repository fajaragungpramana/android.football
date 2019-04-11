package com.mengsoftstudio.android.footballmobile.models.response

import com.google.gson.annotations.SerializedName
import com.mengsoftstudio.android.footballmobile.models.Badge
import com.mengsoftstudio.android.footballmobile.models.Match
import com.mengsoftstudio.android.footballmobile.models.Player
import com.mengsoftstudio.android.footballmobile.models.Team

object Response {

    data class MatchResponse( @SerializedName("events") val events: List<Match> )
    data class TeamResponse( @SerializedName("teams") val teams: List<Team> )
    data class BadgeResponse( @SerializedName("teams") val badge: List<Badge> )
    data class SearchMatchResponse( @SerializedName("event") val event: List<Match> )
    data class PlayerResponse( @SerializedName("player") val player: List<Player> )
    data class SearchTeamResponse( @SerializedName("teams") val teams: List<Team> )
    data class MatchFavoriteResponse( @SerializedName("events") val event: List<Match> )
    data class TeamFavoriteResponse( @SerializedName("teams") val teams: List<Team> )

}