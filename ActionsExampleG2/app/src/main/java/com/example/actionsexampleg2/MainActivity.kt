package com.example.actionsexampleg2

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
        val lblHeading = findViewById<TextView>(R.id.lblHeading)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)
        val btnPress = findViewById<Button>(R.id.btnPress)
        //  set the counter to 0 when the app opens
        var counter : Int = 0
        // when the button is pressed
        btnPress.setOnClickListener {
            // increase the counter by 1
            counter++
            // and display the new value
            lblOutput.text = "You've clicked me ${counter} times!"
        }
    }
}