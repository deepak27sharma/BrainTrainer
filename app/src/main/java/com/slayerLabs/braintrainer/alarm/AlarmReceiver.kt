package com.slayerLabs.braintrainer.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.slayerLabs.braintrainer.BrainTrainer

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        BrainTrainer.getDailyChallengeRepository().getDailyChallengeUrl()
    }

    fun setAlarm(context: Context?, triggerTimeInMs: Long, intervalMs: Long) {
        val alarmManager = getAlarmManager(context)
        val alarmIntent = Intent(context, AlarmReceiver::class.java).let {
                intent -> PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        }
        alarmManager?.setInexactRepeating(AlarmManager.RTC_WAKEUP,
            triggerTimeInMs, intervalMs, alarmIntent)
    }

    fun cancelAlarm(context: Context?) {
        val alarmManager = getAlarmManager(context)
        val alarmIntent = Intent(context, AlarmReceiver::class.java).let {
            intent -> PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        }
        alarmManager?.cancel(alarmIntent)
    }

    private fun getAlarmManager(context: Context?) : AlarmManager? {
        return context?.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
    }
}