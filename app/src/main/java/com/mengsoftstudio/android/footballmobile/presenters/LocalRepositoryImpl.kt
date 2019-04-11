package com.mengsoftstudio.android.footballmobile.presenters

import android.content.Context
import com.mengsoftstudio.android.footballmobile.extensions.sqlite
import com.mengsoftstudio.android.footballmobile.models.MatchFavorite
import com.mengsoftstudio.android.footballmobile.models.TeamFavorite
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(private val context: Context) {

    fun setMatchFavorite(idEvent: String) {

        context.sqlite.use {

            insert(MatchFavorite.TABLE_NAME,
                MatchFavorite.ID_EVENT to idEvent
            )

        }

    }

    fun getMatchFavorite(): List<MatchFavorite> {
        lateinit var matchFavorite: List<MatchFavorite>

        context.sqlite.use {
            val match = select(MatchFavorite.TABLE_NAME).parseList(classParser<MatchFavorite>())
            matchFavorite = match
        }

        return matchFavorite
    }

    fun hasMatchFavorite(idEvent: String): List<MatchFavorite> =

            context.sqlite.use {
                val match = select(MatchFavorite.TABLE_NAME).whereArgs("(ID_EVENT = {id})", "id" to idEvent)
                    .parseList(classParser<MatchFavorite>())

                match
            }

    fun removeMatchFavorite(idEvent: String) {

        context.sqlite.use {
            delete(MatchFavorite.TABLE_NAME, "(ID_EVENT = {id})", "id" to idEvent)
        }

    }

    fun setTeamFavorite(idTeam: String) {

        context.sqlite.use {

            insert(TeamFavorite.TABLE_NAME,
                    TeamFavorite.ID_TEAM to idTeam)

        }

    }

    fun getTeamFavorite(): List<TeamFavorite> {
        lateinit var teamFavorite: List<TeamFavorite>

        context.sqlite.use {
            val team = select(TeamFavorite.TABLE_NAME).parseList(classParser<TeamFavorite>())
            teamFavorite = team
        }

        return teamFavorite
    }

    fun hasTeamFavorite(idTeam: String): List<TeamFavorite> =

            context.sqlite.use {
                val team = select(TeamFavorite.TABLE_NAME).whereArgs("(ID_TEAM = {id})", "id" to idTeam)
                        .parseList(classParser<TeamFavorite>())

                team
            }

    fun removeTeamFavorite(idTeam: String) {

        context.sqlite.use {
            delete(TeamFavorite.TABLE_NAME, "(ID_TEAM = {id})", "id" to idTeam)
        }

    }

}