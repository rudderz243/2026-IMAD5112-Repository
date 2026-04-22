package com.example.submissionrecapg1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
        val lblHeading = findViewById<TextView>(R.id.lblHeading)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        val btnPress = findViewById<Button>(R.id.btnPress)

        btnPress.setOnClickListener {
            // for Toast.makeText, we need to give the following:
            // 1) this = this tells the app we want to make toast on THIS screen
            // 2) the text we want to display in "quotes"
            // 3) the length - you have two options. Toast.LENGTH_SHORT or Toast.LENGTH_LONG
            // we finish off with .show()
            Toast.makeText(this, "I am submitting my assignment", Toast.LENGTH_SHORT).show()
            //fjklsdjglkasdfjgkldsfglkj

        }
    }
}