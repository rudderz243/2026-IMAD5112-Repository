package com.example.recap1g1

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
        // text views
        val lblHeadingWelcome = findViewById<TextView>(R.id.lblHeadingWelcome)
        val lblDescriptionWelcome = findViewById<TextView>(R.id.lblDescriptionWelcome)

        // buttons
        val btnBeginWelcome = findViewById<Button>(R.id.btnBeginWelcome)
        val btnCloseWelcome = findViewById<Button>(R.id.btnCloseWelcome)

        btnBeginWelcome.setOnClickListener {
            val screen2 = Intent(this, Screen2::class.java)
            startActivity(screen2)
        }
        btnCloseWelcome.setOnClickListener {
            finishAffinity()
        }
    }
}