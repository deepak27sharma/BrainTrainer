package com.slayerLabs.braintrainer.query

import com.android.volley.VolleyError
import org.json.JSONObject
object QueryResponseProcessor {
    interface QueryResponseListener {
        fun onQuerySuccess(questionLink: String)
        fun onQueryError(error: VolleyError) = Unit
    }
    val listenerSet = hashSetOf<QueryResponseListener>()
    fun addQueryReponseListener(listener: QueryResponseListener) {
        listenerSet.add(listener)
    }
    fun removeQueryResponseListener(listener: QueryResponseListener) {
        listenerSet.remove(listener)
    }
    fun onQuerySuccess(questionLink: String) {
        for(listener in listenerSet) {
            listener.onQuerySuccess(questionLink)
        }
    }
    fun onQueryError(error: VolleyError) {
        for(listener in listenerSet) {
            listener.onQueryError(error)
        }
    }
}