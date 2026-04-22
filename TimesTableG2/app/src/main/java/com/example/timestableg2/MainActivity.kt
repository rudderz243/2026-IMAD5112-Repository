package com.example.timestableg2

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
        val txtNumber = findViewById<EditText>(R.id.txtNumber)
        val txtCount = findViewById<EditText>(R.id.txtCount)

        // button
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            // get in the user inputs
            val numberToMultiply = txtNumber.text.toString().toInt() // the user entered 7
            val numberToMultiplyUntil = txtCount.text.toString().toInt() // the user entered 5

            // variables for our loop
            var counterVariable = 0
            var outputText = ""

            while (counterVariable <= numberToMultiplyUntil) {
                // every time the loop runs, we must:
                // 1: calculate the result of the timestable calculation
                var calculation = numberToMultiply * counterVariable
                // 2: we need to print out the sum, as well as the answer to the calculation ( \n means go to the next line )
                outputText += "${numberToMultiply} x ${counterVariable} = ${calculation} \n"
                // 3: increase the counter
                counterVariable++
            }
            lblOutput.text = outputText
        }

    }
}