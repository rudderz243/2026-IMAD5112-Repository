package com.example.looprecapg2

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
            // we call in the user inputs
            val endNumber = txtEndNumber.text.toString().toInt()
            val multiple = txtMultiple.text.toString().toInt()
            // we create a new variable to hold our output as we go
            var outputString = ""

            for (counter in 0..endNumber) // while (counter <= endNumber)
            {
                if (counter % multiple == 0) // this checks whether a number is a multiple
                {
                    outputString += "${counter}\n"
                }
            }
            // once the loop is done, we add the final message, and print it to the label
            outputString += "This is all the multiples of $multiple between 0 and $endNumber"
            lblOutput.text = outputString
        }
    }
}