package com.slayerLabs.braintrainer

import android.app.Application
import android.content.Context
import com.slayerLabs.braintrainer.alarm.AlarmReceiver
import com.slayerLabs.braintrainer.query.DailyChallengeRepository
import com.slayerLabs.braintrainer.query.QueryController

class BrainTrainer: Application() {
    init {
        instance = this
    }
    override fun onCreate() {
        super.onCreate()

        QueryController.initializeRequestQueue()
        mDailyChallengeRepository = DailyChallengeRepository()
        mAlarmReceiver = AlarmReceiver()
    }
    companion object {
        private var instance: BrainTrainer? = null
        private var mDailyChallengeRepository: DailyChallengeRepository? = null
        private var mAlarmReceiver: AlarmReceiver? = null
        fun getApplicationContext(): Context {
            return instance!!.applicationContext
        }
        fun getAlarmReceiver(): AlarmReceiver {
            return mAlarmReceiver!!
        }
        fun getDailyChallengeRepository(): DailyChallengeRepository {
            return mDailyChallengeRepository!!
        }
    }
}