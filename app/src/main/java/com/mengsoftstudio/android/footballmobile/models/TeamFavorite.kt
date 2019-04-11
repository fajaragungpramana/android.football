package com.mengsoftstudio.android.footballmobile.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamFavorite (

        val id: Long?,

        val idTeam: String?

) : Parcelable {

    companion object {

        const val TABLE_NAME = "TEAM_FAVORITE"
        const val ID = "ID"

        const val ID_TEAM = "ID_TEAM"

    }

}