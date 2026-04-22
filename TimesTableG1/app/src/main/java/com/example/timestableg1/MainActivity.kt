package com.example.timestableg1

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

        // edittext (numbers)
        val txtNumber = findViewById<EditText>(R.id.txtNumber)
        val txtCount = findViewById<EditText>(R.id.txtCount)

        // button
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            // get in the user inputs
            val numberToMultiply = txtNumber.text.toString().toInt()
            val numberToOutput = txtCount.text.toString().toInt()
            // set our starting point
            var counterVariable = 0
            // variable to store the output text
            var outputText = ""

            while (counterVariable < numberToOutput) {
                // calculate the sum
                var sum = numberToMultiply * counterVariable
                // display the answer
                outputText += "${numberToMultiply} x ${counterVariable} = ${sum} \n"
                // increase the counter, so that we can keep track of where we are
                counterVariable++
            }
            lblOutput.text = outputText
        }


    }
}