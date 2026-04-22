package com.example.mathtestg1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lblHeadingQuiz = findViewById<TextView>(R.id.lblHeadingQuiz)
        val lblQuestionQuiz = findViewById<TextView>(R.id.lblQuestionQuiz)
        val lblFeedbackQuiz = findViewById<TextView>(R.id.lblFeedbackQuiz)
        val btnTrueQuiz = findViewById<Button>(R.id.btnTrueQuiz)
        val btnFalseQuiz = findViewById<Button>(R.id.btnFalseQuiz)
        val btnStartQuiz = findViewById<Button>(R.id.btnStartQuiz)
        val btnResultsQuiz = findViewById<Button>(R.id.btnResultsQuiz)

        val question1 = "2 + 2 = 2"
        val answer1 = false
        val question2 = "3 > 4"
        val answer2 = false
        val question3 = "A circle is 180 degrees"
        val answer3 = false
        val question4 = "2 is a whole number"
        val answer4 = true
        val question5 = "sin(90) + cos(0) = 2tan(45)"
        val answer5 = true

        var userScore = 0
        var currentQuestion = 1

        btnTrueQuiz.setOnClickListener {
            // use a for loop, to determine if the answer for the current question is true
            for (question in 1..5) {
                // if the current question is equal to the place in the loop
                if (currentQuestion == question) {
                    // check for the specific questions that have "true" as their answer
                    if (question == 4 || question == 5) {
                        // because they answered correctly, we increase their score
                        userScore++
                        lblFeedbackQuiz.text = "Correct! Score: $userScore"
                    } else {
                        // if they chose true for a question thats NOT, they answered incorrectly
                        lblFeedbackQuiz.text = "Incorrect! Score: $userScore"
                    }
                    // exit the loop early, so we don't have to run it more than needed
                    break
                }
            }
            // move on to the next question, and prepare the app for the next answer
            currentQuestion++
            // we use the when statement to update what question we are on
            when (currentQuestion) {
                2 -> lblQuestionQuiz.text = question2
                3 -> lblQuestionQuiz.text = question3
                4 -> lblQuestionQuiz.text = question4
                5 -> lblQuestionQuiz.text = question5
                else -> {
                    lblQuestionQuiz.text = "Quiz Complete! Total: $userScore"
                    btnTrueQuiz.isEnabled = false
                    btnFalseQuiz.isEnabled = false
                }
            }
        }
        btnFalseQuiz.setOnClickListener {
            // use a for loop, to determine if the answer for the current question is true
            for (question in 1..5) {
                // if the current question is equal to the place in the loop
                if (currentQuestion == question) {
                    // check for the specific questions that have "true" as their answer
                    if (question == 1 || question == 2 || question == 3) {
                        // because they answered correctly, we increase their score
                        userScore++
                        lblFeedbackQuiz.text = "Correct! Score: $userScore"
                    } else {
                        // if they chose true for a question thats NOT, they answered incorrectly
                        lblFeedbackQuiz.text = "Incorrect! Score: $userScore"
                    }
                    // exit the loop early, so we don't have to run it more than needed
                    break
                }
            }
            // move on to the next question, and prepare the app for the next answer
            currentQuestion++
            // we use the when statement to update what question we are on
            when (currentQuestion) {
                2 -> lblQuestionQuiz.text = question2
                3 -> lblQuestionQuiz.text = question3
                4 -> lblQuestionQuiz.text = question4
                5 -> lblQuestionQuiz.text = question5
                else -> {
                    lblQuestionQuiz.text = "Quiz Complete! Total: $userScore"
                    btnTrueQuiz.isEnabled = false
                    btnFalseQuiz.isEnabled = false
                }
            }
        }
        btnStartQuiz.setOnClickListener {
            // reset the score
            userScore = 0
            // set the app back to question 1
            currentQuestion = 1
            lblQuestionQuiz.text = question1
            // enable the controls
            btnTrueQuiz.isEnabled = true
            btnFalseQuiz.isEnabled = true
        }
        btnTrueQuiz.isEnabled = false
        btnFalseQuiz.isEnabled = false
    }
}