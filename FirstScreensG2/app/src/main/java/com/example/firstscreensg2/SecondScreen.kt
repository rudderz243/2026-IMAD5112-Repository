package com.example.firstscreensg2

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
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnToast = findViewById<Button>(R.id.btnToast)

        btnBack.setOnClickListener {
            // to go back to the previous screen, once we are finished on this screen, we say:
            finish()
        }

        btnToast.setOnClickListener {
            // toast needs 3 elements, it needs:
            // 1. where to show the toast
            // 2. what to say in the toast
            // 3. how long to show the toast
            Toast.makeText(this, "Yum!", Toast.LENGTH_SHORT).show()
        }

    }
}