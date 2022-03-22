package com.slayerLabs.braintrainer.query

interface DailyChallengeModel {
    enum class DifficultyLevel(s: String) {
        EASY("Easy"),
        MEDIUM("Medium"),
        HARD("Hard")
    }
    enum class StartStatus(s: String) {
        NOT_STARTED("NotStart"),
        STARTED("Start"), //Get correct values from response
        COMPLETED("Finished")
    }
    fun setCurrentDate(date: String)
    fun getCurrentDate(): String
    fun setStartStatus(startState: String) //convert to StartStatus enum
    fun getStartStatus(): StartStatus
    fun setQuestionLink(link: String)
    fun getQuestionLink(): String
    fun setAcceptanceRate(percent: Double)
    fun getAcceptanceRate(): Double
    fun setDifficultyLevel(level: String) //convert to DifficultyLevel enum
    fun getDifficultyLevel(): DifficultyLevel
    fun setQuestionId(id: String)
    fun getQuestionId(): String
    fun setIsPaidOnly(isPaidOnly: Boolean)
    fun getIsPaidOnly(): Boolean
    fun setQuestionTitle(title: String)
    fun getQuestionTitle(): String
    fun setIsSolutionAvailable(hasSolution: Boolean)
    fun getIsSolutionAvailable(): Boolean
    fun setTopicTags(topicList: List<String>)
    fun getTopicTags(): List<String>
}