package com.example.submissionrecapg2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
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

        val main = findViewById<ConstraintLayout>(R.id.main)

        main.setBackgroundResource(R.id.NameOfYourPicture)


        
        val lblHeading = findViewById<TextView>(R.id.lblHeading)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        val btnPress = findViewById<Button>(R.id.btnPress)

        btnPress.setOnClickListener {
            // in order to make Toast, we need these 3 ingredients
            // 1) we need to tell the toast which screen it lives on. in most circumstances, we just say THIS
            // 2) we need to tell the toast what to say, in "quotes"
            // 3) we need to tell the toast how LONG to display for; Toast.LENGTH_SHORT or Toast.LENGTH_LONG
            // we add .show() at the end, so our Toast actually displays
            Toast.makeText(this, "I am submitting my assignment", Toast.LENGTH_LONG).show()
        }
    }
}