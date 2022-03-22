package com.slayerLabs.braintrainer.query

object DailyChallengeRepositoryFactory {
    private var repository: DailyChallengeRepository? = null
    fun create() {
        repository = getDailyChallengeRepositoryImpl()
    }
    private fun getDailyChallengeRepositoryImpl() = DailyChallengeRepositoryImpl()
    fun getDailyChallengeRepository(): DailyChallengeRepository {
        return repository ?: object : DailyChallengeRepository { }
    }
}