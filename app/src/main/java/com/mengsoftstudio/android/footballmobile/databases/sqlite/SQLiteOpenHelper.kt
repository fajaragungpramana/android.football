package com.mengsoftstudio.android.footballmobile.databases.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.mengsoftstudio.android.footballmobile.models.MatchFavorite
import com.mengsoftstudio.android.footballmobile.models.TeamFavorite
import org.jetbrains.anko.db.*

class SQLiteOpenHelper(context: Context) : ManagedSQLiteOpenHelper(context, "Favorites.db", null, 1) {

    companion object {
        private var sqlite: SQLiteOpenHelper? = null

        @Synchronized
        fun getInstance(context: Context): SQLiteOpenHelper {
            if(sqlite == null)
                sqlite = SQLiteOpenHelper(context.applicationContext)

            return sqlite!!
        }

    }

    override fun onCreate(db: SQLiteDatabase?) {

        db?.createTable(MatchFavorite.TABLE_NAME, true,
            MatchFavorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,

            MatchFavorite.ID_EVENT to TEXT
            )

        db?.createTable(TeamFavorite.TABLE_NAME, true,
                TeamFavorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,

                TeamFavorite.ID_TEAM to TEXT)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(MatchFavorite.TABLE_NAME, true)
        db?.dropTable(TeamFavorite.TABLE_NAME, true)
    }

}