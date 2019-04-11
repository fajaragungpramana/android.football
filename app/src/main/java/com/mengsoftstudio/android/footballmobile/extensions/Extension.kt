package com.mengsoftstudio.android.footballmobile.extensions

import android.content.Context
import android.view.View
import com.mengsoftstudio.android.footballmobile.databases.sqlite.SQLiteOpenHelper

fun View.visible() { visibility = View.VISIBLE }

fun View.gone() { visibility = View.GONE }

val Context.sqlite: SQLiteOpenHelper
    get() = SQLiteOpenHelper.getInstance(applicationContext)