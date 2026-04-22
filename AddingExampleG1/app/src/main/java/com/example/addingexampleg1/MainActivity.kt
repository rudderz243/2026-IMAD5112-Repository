package com.example.addingexampleg1

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

        // edittext (number)
        val txtNumber = findViewById<EditText>(R.id.txtNumber)

        // buttons
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnOdd = findViewById<Button>(R.id.btnOdd)
        val btnEven = findViewById<Button>(R.id.btnEven)

        btnReset.setOnClickListener {
            txtNumber.text.clear()
            lblOutput.text = ""
        }

        btnOdd.setOnClickListener {
            // keeping track of the total
            var sum = 0
            // the number we are adding until
            val endingNumber = txtNumber.text.toString().toInt()

            // this line creates a new variable called counter, and then sets
            // the instructions for the loop to run over and over again, while the
            // counter variable is between 1 and the endingNumber (the user input)
            for (counter in 1..endingNumber) {
                // % is MOD, it means divide the 2 numbers, but take the remainder
                // instead of the answer to the division sum
                // e.g. 4 % 2 = 0 (2 goes into 4 twice, with nothing left over)
                // 5 % 2 = 1 (2 goes into 5 twice, with 1 left over)
                if (counter % 2 > 0) { // checks whether there is a remainder
                    // if there is, we add the number to our sum
                    sum += counter
                }
            }
            // once the loop is done, we print out the calculated answer
            lblOutput.text = "The sum of all the odd numbers is ${sum}"
        }

        btnEven.setOnClickListener {
            // to keep track of the total
            var sum = 0
            // the ending point of the loop (user input)
            val endingNumber = txtNumber.text.toString().toInt()
            // for a while loop, we need to create our own counter to keep track
            var loopCounter = 1
            // this while loop works the same way as the for loop for the Odd button
            while (loopCounter <= endingNumber) {
                if (loopCounter % 2 == 0) { // this time, if the number is EVEN (no remainder), we add
                    sum += loopCounter
                }
                // with a while loop, you have to increase the counter on your own
                loopCounter++
            }
            // output the answer
            lblOutput.text = "The sum of all even numbers is ${sum}"
        }
    }
}