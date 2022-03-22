package com.slayerLabs.braintrainer

import android.app.Application
import android.content.Context
import com.slayerLabs.braintrainer.alarm.AlarmReceiver
import com.slayerLabs.braintrainer.query.DailyChallengeRepositoryImpl
import com.slayerLabs.braintrainer.query.QueryController

class BrainTrainer: Application() {
    init {
        instance = this
    }
    override fun onCreate() {
        super.onCreate()

        QueryController.initializeRequestQueue()
        mDailyChallengeRepository = DailyChallengeRepositoryImpl()
        mAlarmReceiver = AlarmReceiver()
    }
    companion object {
        private var instance: BrainTrainer? = null
        private var mDailyChallengeRepository: DailyChallengeRepositoryImpl? = null
        private var mAlarmReceiver: AlarmReceiver? = null
        fun getApplicationContext(): Context {
            return instance!!.applicationContext
        }
        fun getAlarmReceiver(): AlarmReceiver {
            return mAlarmReceiver!!
        }
        fun getDailyChallengeRepository(): DailyChallengeRepositoryImpl {
            return mDailyChallengeRepository!!
        }
    }
}