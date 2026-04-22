package com.example.mathtestg1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lblHeadingHome = findViewById<TextView>(R.id.lblHeadingHome)
        val lblDescriptionHome = findViewById<TextView>(R.id.lblDescriptionHome)
        val btnStartHome = findViewById<Button>(R.id.btnStartHome)
        val btnCloseHome = findViewById<Button>(R.id.btnCloseHome)

        btnStartHome.setOnClickListener {
            val quizScreen = Intent(this, QuizScreen::class.java)
            startActivity(quizScreen)
        }

        btnCloseHome.setOnClickListener {
            finishAffinity()
        }
    }
}