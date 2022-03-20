package com.slayerLabs.braintrainer.event

import android.content.Context
import android.content.Intent
import android.provider.CalendarContract
import java.util.*

class CalendarEvent {
    fun addEvent(context: Context, description: String) {
        val rightNow = Calendar.getInstance()
        rightNow.set(Calendar.HOUR_OF_DAY, 18)
        rightNow.set(Calendar.MINUTE, 0)
        rightNow.set(Calendar.SECOND, 0)
        val beginTimeInMs = rightNow.timeInMillis
        rightNow.set(Calendar.HOUR_OF_DAY, 23)
        val endTimeInMs = rightNow.timeInMillis

        val intent = Intent(Intent.ACTION_INSERT)
            .setData(CalendarContract.Events.CONTENT_URI)
            .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTimeInMs)
            .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTimeInMs)
            .putExtra(CalendarContract.Events.TITLE, "Leetcode Daily Challenge")
            .putExtra(CalendarContract.Events.DESCRIPTION, description)
        context.startActivity(intent)
    }
}