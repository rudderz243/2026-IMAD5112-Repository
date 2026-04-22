package com.example.mathtestg1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lblHeadingResults = findViewById<TextView>(R.id.lblHeadingResults)
        val lblFinalScoreResults = findViewById<TextView>(R.id.lblFinalScoreResults)
        val lblMemoResults = findViewById<TextView>(R.id.lblMemoResults)
        val btnCloseResults = findViewById<Button>(R.id.btnCloseResults)
        val btnHomeResults = findViewById<Button>(R.id.btnHomeResults)

        val finalScore = intent.getIntExtra("userScore", 0)

        lblFinalScoreResults.text = "Your final score was: $finalScore"
        lblMemoResults.text = "The memo is <insert memo here, i'm not typing it out now for time>"

        btnCloseResults.setOnClickListener {
            finishAffinity()
        }
        btnHomeResults.setOnClickListener {
            val homeScreen = Intent(this, MainActivity::class.java)
            startActivity(homeScreen)
        }











    }
}