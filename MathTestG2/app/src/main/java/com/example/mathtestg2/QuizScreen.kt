package com.example.mathtestg2

import android.content.Intent
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
        val lblResponseQuiz = findViewById<TextView>(R.id.lblResponseQuiz)

        val btnTrueQuiz = findViewById<Button>(R.id.btnTrueQuiz)
        val btnFalseQuiz = findViewById<Button>(R.id.btnFalseQuiz)
        val btnStartQuiz = findViewById<Button>(R.id.btnStartQuiz)
        val btnViewResultsQuiz = findViewById<Button>(R.id.btnViewResultsQuiz)

        val question1 = "2 + 2 = 4"
        val answer1 = true
        val question2 = "3 > 4"
        val answer2 = false
        val question3 = "It is impossible to get an odd number by adding 2 even numbers"
        val answer3 = true
        val question4 = "A circle is 180 degrees"
        val answer4 = false
        val question5 = "sin(90) + cos(0) = 2tan(45)"
        val answer5 = true

        var userScore = 0

        btnViewResultsQuiz.setOnClickListener {
            val resultsScreen = Intent(this, ScoreScreen::class.java)
            resultsScreen.putExtra("userScore", userScore)
            startActivity(resultsScreen)

        }

        var currentQuestion = 1
        // btnTrue and btnFalse will start out disabled (turned off), we don't want the user to be able
        // to answer questions before they've started the quiz
        btnTrueQuiz.isEnabled = false
        btnFalseQuiz.isEnabled = false

        btnStartQuiz.setOnClickListener {
            // we need to reset their score
            userScore = 0
            // load question 1 into the textview so the user can begin answering
            currentQuestion = 1
            lblQuestionQuiz.text = question1
            btnTrueQuiz.isEnabled = true
            btnFalseQuiz.isEnabled = true
        }

        btnTrueQuiz.setOnClickListener {
            // we are going to use a loop to keep track of what question we are on
            for (question in 1..5) {
                // next we check if we're on the current question
                if (question == currentQuestion) {
                    // next we check for the specific questions that have "True" as their answer
                    if (question == 1 || question == 3 || question == 5) {
                        // since these questions are correct, we increase the score
                        userScore++
                        lblResponseQuiz.text = "Correct! Score: $userScore"
                    } else {
                        // if it is not one of the questions that are "True", we give feedback
                        lblResponseQuiz.text = "Incorrect. Score: $userScore"
                    }
                    // once we have found the correct question, we exit the loop so that it doesn't have to
                    // keep on running (break means exit in programming)
                    break
                }

            }
            // we prepare the application to handle the next question
            currentQuestion++
            // we use a when statement to ensure that the correct question is shown next
            when (currentQuestion) {
                2 -> lblQuestionQuiz.text = question2
                3 -> lblQuestionQuiz.text = question3
                4 -> lblQuestionQuiz.text = question4
                5 -> lblQuestionQuiz.text = question5
                else -> {
                    lblQuestionQuiz.text = "Quiz Complete!"
                    lblResponseQuiz.text = "Final Score: $userScore"
                    btnTrueQuiz.isEnabled = false
                    btnFalseQuiz.isEnabled = false
                }
            }
        }
        // change this to false
        btnFalseQuiz.setOnClickListener {
            // we are going to use a loop to keep track of what question we are on
            for (question in 1..5) {
                // next we check if we're on the current question
                if (question == currentQuestion) {
                    // next we check for the specific questions that have "False" as their answer
                    if (question == 2 || question == 4) { // change these question numbers
                        // since these questions are correct, we increase the score
                        userScore++
                        lblResponseQuiz.text = "Correct! Score: $userScore"
                    } else {
                        // if it is not one of the questions that are "True", we give feedback
                        lblResponseQuiz.text = "Incorrect. Score: $userScore"
                    }
                    // once we have found the correct question, we exit the loop so that it doesn't have to
                    // keep on running (break means exit in programming)
                    break
                }


            }
            // we prepare the application to handle the next question
            currentQuestion++
            // we use a when statement to ensure that the correct question is shown next
            when (currentQuestion) {
                2 -> lblQuestionQuiz.text = question2
                3 -> lblQuestionQuiz.text = question3
                4 -> lblQuestionQuiz.text = question4
                5 -> lblQuestionQuiz.text = question5
                else -> {
                    lblQuestionQuiz.text = "Quiz Complete!"
                    lblResponseQuiz.text = "Final Score: $userScore"
                    btnTrueQuiz.isEnabled = false
                    btnFalseQuiz.isEnabled = false
                }
            }
        }

    }
}