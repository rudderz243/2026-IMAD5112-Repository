package com.example.addingexampleg2

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
            var sum = 0
            // the number we want to count until (user input)
            val endingNumber = txtNumber.text.toString().toInt()

            // a for loop always runs for a fixed number of runs. when we create a for loop, we:
            // first: give it a name so it can create a new counter variable for us (the loop controls all aspects of this variable)
            // second: give it the range it needs to run for (for example 1 to 10 would be 1..10, but we can use a variable instead of a number)
            for (counter in 1..endingNumber) { // while (counter <= endingNumber) { }
                // using the % instead of a / gives us the REMAINDER of the division sum, rather than the ANSWER
                // e.g., 4 % 2 = 0 (no remainder), 7 % 2 = 1 (2 goes into 7 3 times, with 1 left over)
                if (counter % 2 > 0) { // check if the number is odd
                    // += adds a value to an existing value, we add the counter value to our total sum
                    sum += counter
                }
            }
            // once the loop is done, display the answer
            lblOutput.text = "The total sum of all odd numbers is ${sum}"
        }

        btnEven.setOnClickListener {
            // declare a sum variable to keep track of the total
            var sum = 0
            // get the user input (the ending value of the loop)
            val endingNumber = txtNumber.text.toString().toInt()
            // because we are using a while loop, we need to manually create our counter variable
            var counter = 0
            // so this runs from the initial value of counter (0), up until the user input, same as the for loop
            while (counter <= endingNumber) { // for (counter in 0..endingNumber) { }
                if (counter % 2 == 0) { // in this case, we want NO remainder (even numbers are divisible by 2 with nothing left over)
                    sum += counter
                }
                // because we are using a while loop, we need to MANUALLY increase our counter as we go
                counter++
            }
            // finally, print out the sum the same way
            lblOutput.text = "The total sum of all even numbers is ${sum}"
        }
    }
}