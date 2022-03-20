package com.slayerLabs.braintrainer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.slayerLabs.braintrainer.alarm.AlarmExecutor

class BootReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val alarmExecutor = AlarmExecutor(context, BrainTrainer.getAlarmReceiver())
        alarmExecutor.setRecurringAlarm()
    }
}