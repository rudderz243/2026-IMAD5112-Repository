package com.example.recap2g2

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
        val lblHeadingS1 = findViewById<TextView>(R.id.lblHeadingS1)
        val lblGreetingS1 = findViewById<TextView>(R.id.lblGreetingS1)
        // buttons
        val btnStartS1 = findViewById<Button>(R.id.btnStartS1)
        val btnCloseS1 = findViewById<Button>(R.id.btnCloseS1)

        // btnStart creates an intent that will take the user to Screen2
        btnStartS1.setOnClickListener {
            val screen2 = Intent(this, Screen2::class.java)
            startActivity(screen2)
        }

        // btnClose will exist the application
        btnCloseS1.setOnClickListener {
            finishAffinity()
        }
    }
}