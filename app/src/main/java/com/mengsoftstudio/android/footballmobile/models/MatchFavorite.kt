package com.mengsoftstudio.android.footballmobile.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class  MatchFavorite (

    val id: Long?,

    val idEvent: String?

) : Parcelable {

    companion object {

        const val TABLE_NAME = "MATCH_FAVORITE"
        const val ID = "ID"

        const val ID_EVENT = "ID_EVENT"

    }

}