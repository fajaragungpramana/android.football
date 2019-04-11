package com.mengsoftstudio.android.footballmobile.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team (

    @SerializedName("idTeam")
    val idTeam: String?,

    @SerializedName("strTeam")
    val teamName: String?,

    @SerializedName("intFormedYear")
    val teamFormedYear: String?,

    @SerializedName("strStadium")
    val teamStadium: String?,

    @SerializedName("strDescriptionEN")
    val teamDesc: String?,

    @SerializedName("strTeamBadge")
    val teamBadge: String?

) : Parcelable