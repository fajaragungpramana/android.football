package com.mengsoftstudio.android.footballmobile.views.activity

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import com.mengsoftstudio.android.footballmobile.views.fragment.FavoritesFragment
import com.mengsoftstudio.android.footballmobile.views.fragment.MatchesFragment
import com.mengsoftstudio.android.footballmobile.views.fragment.TeamsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.support_toolbar.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private var isExit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(support_toolbar)

        bnv_main.setOnNavigationItemSelectedListener {

            when(it.itemId) {

                R.id.nav_matches -> {
                    replaceFragment(MatchesFragment())
                    supportActionBar?.title = getString(R.string.toolbar_title_football_matches)

                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_teams -> {
                    replaceFragment(TeamsFragment())
                    supportActionBar?.title = getString(R.string.toolbar_title_football_teams)

                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_favorites -> {
                    replaceFragment(FavoritesFragment())
                    supportActionBar?.title = getString(R.string.toolbar_title_football_favorites)
                    return@setOnNavigationItemSelectedListener true
                }

            }

            return@setOnNavigationItemSelectedListener false

        }

        if(savedInstanceState == null)
            bnv_main.selectedItemId = R.id.nav_matches

    }

    override fun onBackPressed() {

        if(isExit)
            finish()
        else {

            isExit = true
            toast(getString(R.string.alert_press_again_to_exit))

            Handler().postDelayed({
                isExit = false
            }, Constant.BACK_TIME)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_main, menu)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_container_main, fragment)
                .commitNowAllowingStateLoss()

    }

}