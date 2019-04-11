package com.mengsoftstudio.android.footballmobile.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player (

        @SerializedName("strNationality")
        val playerNationality: String?,

        @SerializedName("strPlayer")
        val playerName: String?,

        @SerializedName("strTeam")
        val playerTeam: String?,

        @SerializedName("dateBorn")
        val playerDateBorn: String?,

        @SerializedName("dateSigned")
        val playerDateSigned: String?,

        @SerializedName("strSigning")
        val playerSigning: String?,

        @SerializedName("strBirthLocation")
        val playerBirthLoc: String?,

        @SerializedName("strDescriptionEN")
        val playerDesc: String?,

        @SerializedName("strGender")
        val playerGender: String?,

        @SerializedName("strPosition")
        val playerPosition: String?,

        @SerializedName("strHeight")
        val playerHeight: String?,

        @SerializedName("strWeight")
        val playerWeight: String?,

        @SerializedName("strCutout")
        val playerPic: String?,

        @SerializedName("strFanart2")
        val playerFansArt: String?

) : Parcelable