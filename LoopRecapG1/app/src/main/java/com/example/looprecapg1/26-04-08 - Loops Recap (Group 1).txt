package com.example.looprecapg1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        // edittexts (number)
        val txtEndNumber = findViewById<EditText>(R.id.txtEndNumber)
        val txtMultiple = findViewById<EditText>(R.id.txtMultiple)

        // button
        val btnCheck = findViewById<Button>(R.id.btnCheck)

        btnCheck.setOnClickListener {
            // user input
            val endNumber = txtEndNumber.text.toString().toInt()
            val multiple = txtMultiple.text.toString().toInt()
            // output string
            var outputString = ""

            for (counter in 0..endNumber) {
                // if we divide the current number in the counter by the user input for multiple, and there
                // is no remainder, then that number is a multiple of that number
                if (counter % multiple == 0) {
                    // we add the number to our output string
                    outputString += "${counter}\n"
                }
            }
            outputString += "These are all the multiples of ${multiple} between 0 and ${endNumber}"
            lblOutput.text = outputString
        }


    }
}