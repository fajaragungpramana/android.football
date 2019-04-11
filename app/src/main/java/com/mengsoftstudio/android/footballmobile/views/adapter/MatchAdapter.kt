package com.mengsoftstudio.android.footballmobile.views.adapter

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.CalendarContract
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.extensions.gone
import com.mengsoftstudio.android.footballmobile.extensions.visible
import com.mengsoftstudio.android.footballmobile.models.Match
import com.mengsoftstudio.android.footballmobile.models.constant.Constant
import com.mengsoftstudio.android.footballmobile.views.activity.MatchDetailActivity
import kotlinx.android.synthetic.main.adapter_match.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MatchAdapter(private val matchList: List<Match>, private val context: Context) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_match, parent, false))

    override fun getItemCount(): Int =
        matchList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindMatch(matchList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindMatch(match: Match) {

            try {

                if (match.dateMatch == null || match.timeMatch == null) {
                    itemView.txt_date_match.text = context.getString(R.string.negative)
                    itemView.txt_time_match.text = context.getString(R.string.negative)
                } else if (match.dateMatch.equals("") || match.timeMatch.equals("")) {
                    itemView.txt_date_match.text = context.getString(R.string.negative)
                    itemView.txt_time_match.text = context.getString(R.string.negative)
                } else {
                    itemView.txt_date_match.text = SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault())
                            .format( SimpleDateFormat("yyyy-MM-d", Locale.US).parse(match.dateMatch) )

                    itemView.txt_time_match.text = SimpleDateFormat("HH:mm", Locale.getDefault())
                            .format( SimpleDateFormat("HH:mm:ssZ", Locale.US).parse(match.timeMatch) )

                }

            } catch (exc: ParseException) {
                exc.printStackTrace()
            }

            if (match.homeTeam == null || match.awayTeam == null) {
                itemView.txt_home_team.text = context.getString(R.string.negative)
                itemView.txt_away_team.text = context.getString(R.string.negative)
            } else if (match.homeTeam.equals("") || match.awayTeam.equals("")) {
                itemView.txt_home_team.text = context.getString(R.string.negative)
                itemView.txt_away_team.text = context.getString(R.string.negative)
            } else {
                itemView.txt_home_team.text = match.homeTeam
                itemView.txt_away_team.text = match.awayTeam
            }

            if (match.homeScore == null || match.awayScore == null) {
                itemView.btn_see_details.gone()
                itemView.img_add_to_calendar.visible()

                itemView.txt_home_score.text = ""
                itemView.txt_away_score.text = ""

            } else if (match.homeScore.equals("") || match.awayScore.equals("")) {
                itemView.txt_home_score.text = ""
                itemView.txt_away_score.text = ""
            } else {
                itemView.btn_see_details.visible()
                itemView.img_add_to_calendar.gone()

                itemView.txt_home_score.text = match.homeScore
                itemView.txt_away_score.text = match.awayScore

            }

            itemView.btn_see_details.setOnClickListener {
                context.startActivity(context.intentFor<MatchDetailActivity>(Constant.INTENT_TAG_MATCH to match)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            }

            itemView.img_add_to_calendar.setOnClickListener {

                if(isCalendarPermissionGranted()) {

                    try {

                        val startMatch = SimpleDateFormat("yyyy-MM-dd hh:mm:ssZ", Locale.getDefault()).parse("${match.dateMatch} ${match.timeMatch}").time
                        val endMatch = startMatch + 5400000

                        context.startActivity(
                            Intent(Intent.ACTION_EDIT)
                                .setType("vnd.android.cursor.item/event")
                                .putExtra(CalendarContract.Events.TITLE, "${match.homeTeam} vs ${match.awayTeam}")
                                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startMatch)
                                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endMatch)
                                .putExtra(CalendarContract.Events.EVENT_LOCATION, context.getString(R.string.event_location_to_calendar))

                        )

                    } catch (exc: ParseException) {
                        exc.printStackTrace()
                    }

                } else {
                    context.toast(context.getString(R.string.calendar_denied))
                }

            }

        }

        private fun isCalendarPermissionGranted(): Boolean {

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return if(ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(context as Activity, arrayOf(Manifest.permission.WRITE_CALENDAR), 1)

                    false
                } else {
                    true
                }
            }

            return false

        }

    }

}