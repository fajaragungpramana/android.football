package com.mengsoftstudio.android.footballmobile.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Match(

        @SerializedName("idEvent")
        val idEvent: String?,

        @SerializedName("strHomeTeam")
        val homeTeam: String?,

        @SerializedName("strAwayTeam")
        val awayTeam: String?,

        @SerializedName("intHomeScore")
        val homeScore: String?,

        @SerializedName("intAwayScore")
        val awayScore: String?,

        @SerializedName("strHomeGoalDetails")
        val homeGoal: String?,

        @SerializedName("strHomeRedCards")
        val homeRedCard: String?,

        @SerializedName("strHomeYellowCards")
        val homeYellowCard: String?,

        @SerializedName("strHomeLineupGoalkeeper")
        val homeKeeper: String?,

        @SerializedName("strHomeLineupDefense")
        val homeDefense: String?,

        @SerializedName("strHomeLineupMidfield")
        val homeMidfield: String?,

        @SerializedName("strHomeLineupForward")
        val homeForward: String?,

        @SerializedName("strHomeLineupSubstitutes")
        val homeSubstitute: String?,

        @SerializedName("strAwayRedCards")
        val awayRedCard: String?,

        @SerializedName("strAwayYellowCards")
        val awayYellowCard: String?,

        @SerializedName("strAwayGoalDetails")
        val awayGoal: String?,

        @SerializedName("strAwayLineupGoalkeeper")
        val awayKeeper: String?,

        @SerializedName("strAwayLineupDefense")
        val awayDefense: String?,

        @SerializedName("strAwayLineupMidfield")
        val awayMidfield: String?,

        @SerializedName("strAwayLineupForward")
        val awayForward: String?,

        @SerializedName("strAwayLineupSubstitutes")
        val awaySubstitute: String?,

        @SerializedName("dateEvent")
        val dateMatch: String?,

        @SerializedName("strTime")
        val timeMatch: String?,

        @SerializedName("idHomeTeam")
        val idHome: String?,

        @SerializedName("idAwayTeam")
        val idAway: String?,

        @SerializedName("intHomeShots")
        val homeShot: String?,

        @SerializedName("intAwayShots")
        val awayShot: String?

) : Parcelable