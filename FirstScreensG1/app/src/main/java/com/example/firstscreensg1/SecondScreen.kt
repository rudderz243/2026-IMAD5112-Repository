package com.example.firstscreensg1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // textview
        val lblHeadingScreen2 = findViewById<TextView>(R.id.lblHeadingScreen2)

        // buttons
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            // to go back to the previous screen, we only need one line
            finish()
        }

        btnToast.setOnClickListener {
            // toast needs 3 things, (the screen, the text to show, and how long)
            Toast.makeText(this, "Yum!", Toast.LENGTH_SHORT).show()
        }
    }
}