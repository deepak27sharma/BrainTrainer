package com.slayerLabs.braintrainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.android.volley.VolleyError
import com.slayerLabs.braintrainer.event.CalendarEvent
import com.slayerLabs.braintrainer.query.QueryResponseProcessor

class MainActivity : AppCompatActivity(), QueryResponseProcessor.QueryResponseListener {
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        QueryResponseProcessor.addQueryReponseListener(this)

        button.setOnClickListener {
            button.text = "Requesting"
            button.isEnabled = false
            BrainTrainer.getDailyChallengeRepository().getDailyChallengeUrl()
        }
    }

    override fun onQuerySuccess(questionLink: String) {
        run {
            button.text = "Request"
            button.isEnabled = true
            Toast.makeText(this@MainActivity, "Query Success.", Toast.LENGTH_SHORT).show()
            CalendarEvent().addEvent(this, questionLink)
        }
    }

    override fun onQueryError(error: VolleyError) {
        run {
            button.text = "Request"
            button.isEnabled = true
            Toast.makeText(this@MainActivity, "Query failed!", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        QueryResponseProcessor.removeQueryResponseListener(this)
    }
}
