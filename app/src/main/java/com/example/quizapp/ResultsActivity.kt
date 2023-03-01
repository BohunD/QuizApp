package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        var UserName = intent.getStringExtra(Constans.USER_NAME)
        var WrongAnswers = intent.getIntExtra(Constans.WRONG_ANSWERS, 0)
        var TotalQuestions = intent.getIntExtra(Constans.TOTAL_QUESTIONS, 0)
        var CorrectAnswers = TotalQuestions - WrongAnswers

        val tvName: TextView = findViewById(R.id.TVName)
        val tvWrong: TextView = findViewById(R.id.TVWrong)
        val tvCorrect: TextView = findViewById(R.id.TVCorrect)
        val btnRestart: Button = findViewById(R.id.btnRestart)
        tvName.text = UserName
        tvCorrect.text = "${CorrectAnswers.toString()} correct answers"
        tvWrong.text = "$WrongAnswers wrong answers"
        btnRestart.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }


}