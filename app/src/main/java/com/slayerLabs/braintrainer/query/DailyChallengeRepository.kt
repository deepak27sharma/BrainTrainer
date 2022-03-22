package com.slayerLabs.braintrainer.query

interface DailyChallengeRepository {
    fun getDailyChallengeModel(): DailyChallengeModel? = null
    fun queryDailyChallengeQuestion(): Unit { }
}