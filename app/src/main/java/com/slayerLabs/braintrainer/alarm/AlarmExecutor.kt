package com.slayerLabs.braintrainer.alarm

import android.content.Context
import java.util.*

class AlarmExecutor(context: Context?, alarmReceiver: AlarmReceiver) {
    private val mContext = context
    private val mAlarmReceiver = alarmReceiver

    fun setRecurringAlarm() {
        cancelAlarm()

        val rightNow = Calendar.getInstance()
        rightNow.set(Calendar.HOUR_OF_DAY, 17)
        rightNow.set(Calendar.MINUTE, 30)
        rightNow.set(Calendar.SECOND, 0)
        val beginTimeInMs = rightNow.timeInMillis
        mAlarmReceiver.setAlarm(mContext, beginTimeInMs, 24*60*60*1000)
    }

    private fun cancelAlarm() {
        mAlarmReceiver.cancelAlarm(mContext)
    }
}