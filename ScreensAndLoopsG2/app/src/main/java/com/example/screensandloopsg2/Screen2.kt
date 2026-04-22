package com.example.screensandloopsg2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // textviews
        val lblHeadingScreen2 = findViewById<TextView>(R.id.lblHeadingScreen2)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        // button
        val btnBack = findViewById<Button>(R.id.btnBack)

        // get the data from the other screen
        // we used "putExtra" to send, and on the other side, we use "getExtra" to receive
        // for text: getStringExtra, for numbers: getIntExtra
        val multiple = intent.getIntExtra("multiple", 0)
        val endNumber = intent.getIntExtra("endNumber", 0)

        // we need our output string to store the timestable
        var outputString = ""

        for (counter in 0..endNumber) {
            val sum = counter*multiple
            outputString += "$counter x $multiple = $sum \n"
        }
        lblOutput.text = outputString

        btnBack.setOnClickListener {
            finish()
        }
    }
}