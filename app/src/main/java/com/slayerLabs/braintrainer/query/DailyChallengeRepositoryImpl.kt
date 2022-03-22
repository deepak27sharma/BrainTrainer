package com.slayerLabs.braintrainer.query

import android.util.Log
import com.slayerLabs.braintrainer.BrainTrainer
import com.slayerLabs.braintrainer.event.CalendarEvent
import org.json.JSONObject

class DailyChallengeRepositoryImpl(): DailyChallengeRepository,
    QueryResponseProcessor.QueryResponseListener {
    private val TAG = DailyChallengeRepositoryImpl::class.java.simpleName
    private val mQueryUrl = "https://leetcode.com/graphql"
    private val mJsonObject: JSONObject = JSONObject("{\"query\":\"query questionOfToday {\\n\\tactiveDailyCodingChallengeQuestion {\\n\\t\\tdate\\n\\t\\tuserStatus\\n\\t\\tlink\\n\\t\\tquestion {\\n\\t\\t\\tacRate\\n\\t\\t\\tdifficulty\\n\\t\\t\\tfreqBar\\n\\t\\t\\tfrontendQuestionId: questionFrontendId\\n\\t\\t\\tisFavor\\n\\t\\t\\tpaidOnly: isPaidOnly\\n\\t\\t\\tstatus\\n\\t\\t\\ttitle\\n\\t\\t\\ttitleSlug\\n\\t\\t\\thasVideoSolution\\n\\t\\t\\thasSolution\\n\\t\\t\\ttopicTags {\\n\\t\\t\\t\\tname\\n\\t\\t\\t\\tid\\n\\t\\t\\t\\tslug\\n\\t\\t\\t}\\n\\t\\t}\\n\\t}\\n}\\n\",\"operationName\":\"questionOfToday\"}")
    private lateinit var mQuestionLink: String
    init {
        QueryResponseProcessor.addQueryReponseListener(this)
    }
    fun getDailyChallengeUrl() {
        QueryController.jsonObjectRequest(mQueryUrl, mJsonObject, {
            response ->
            val dailyChallengeInfo = response
                .getJSONObject("data")
                .getJSONObject("activeDailyCodingChallengeQuestion")
            val questionLink = "https://leetcode.com${dailyChallengeInfo.getString("link")}"
            Log.i(TAG, "Question Link: $questionLink")
            QueryResponseProcessor.onQuerySuccess(questionLink)
        }, {
            error ->
            Log.i(TAG, "error received: $error")
            QueryResponseProcessor.onQueryError(error)
        })
    }

    override fun onQuerySuccess(questionLink: String) {
        mQuestionLink = questionLink
        CalendarEvent().addEvent(BrainTrainer.getApplicationContext(), questionLink)
    }

    override fun getDailyChallengeModel(): DailyChallengeModel {
        TODO("Not yet implemented")
    }

    override fun queryDailyChallengeQuestion() {
        TODO("Not yet implemented")
    }
}