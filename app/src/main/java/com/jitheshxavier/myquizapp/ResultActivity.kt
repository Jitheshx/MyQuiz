package com.jitheshxavier.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var textViewName: TextView = findViewById(R.id.textViewName)
        var textViewScore: TextView = findViewById(R.id.textViewScore)
        var submitButton: Button = findViewById(R.id.submitButton)


        textViewName.text = intent.getStringExtra(Constants.USER_NAME)
        var score = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        var totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        textViewScore.text = "Your score is $score out of $totalQuestions"

        submitButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}