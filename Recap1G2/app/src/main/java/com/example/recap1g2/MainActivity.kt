package com.example.recap1g2

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
        val btnBeginS1 = findViewById<Button>(R.id.btnBeginS1)
        val btnCloseS1 = findViewById<Button>(R.id.btnCloseS1)

        btnBeginS1.setOnClickListener {
            val screen2 = Intent(this, Screen2::class.java)
            startActivity(screen2)
        }
        btnCloseS1.setOnClickListener {
            finishAffinity()
        }
    }
}