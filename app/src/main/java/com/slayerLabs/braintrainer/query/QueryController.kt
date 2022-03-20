package com.slayerLabs.braintrainer.query

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.slayerLabs.braintrainer.BrainTrainer
import org.json.JSONObject

class QueryController {
    companion object {
        lateinit var queue: RequestQueue
        fun initializeRequestQueue() {
            queue = Volley.newRequestQueue(BrainTrainer.getApplicationContext())
        }
        fun getRequestQueue(): RequestQueue {
            return queue
        }
        fun jsonObjectRequest(url: String, jsonObject: JSONObject,
                              successCallBack: Response.Listener<JSONObject>,
                              errorListener: Response.ErrorListener) {
            val jsonObjectRequest = JsonObjectRequest(Request.Method.POST,
            url, jsonObject, successCallBack, errorListener)
            queue.add(jsonObjectRequest)
        }
    }
}