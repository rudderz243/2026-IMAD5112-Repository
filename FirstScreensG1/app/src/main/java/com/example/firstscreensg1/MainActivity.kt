package com.example.firstscreensg1

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
        // textviews
        val lblHeading = findViewById<TextView>(R.id.lblHeading)
        val lblGreeting = findViewById<TextView>(R.id.lblGreeting)

        // button
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            // here we set up our Intent (which is like a map route) - telling
            // android studio where we are starting, and where we want to go!
            val secondScreen = Intent(this, SecondScreen::class.java)

            startActivity(secondScreen)
        }
    }
}