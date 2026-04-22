package com.example.mathtestg2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lblHeadingScore = findViewById<TextView>(R.id.lblHeadingScore)
        val lblFinalScore = findViewById<TextView>(R.id.lblFinalScore)
        val lblMemoScore = findViewById<TextView>(R.id.lblMemoScore)
        val btnHomeScore = findViewById<Button>(R.id.btnHomeScore)
        val btnCloseScore = findViewById<Button>(R.id.btnCloseScore)
        // we get the final score from the other screen
        val finalScore = intent.getIntExtra("userScore", 0)

        lblFinalScore.text = "Final Score: $finalScore"
        lblMemoScore.text = "You would type your memo here (i am not doing that to save time)"

        btnCloseScore.setOnClickListener {
            finishAffinity()
        }

        btnHomeScore.setOnClickListener {
            val homeScreen = Intent(this, MainActivity::class.java)
            startActivity(homeScreen)
        }

    }
}