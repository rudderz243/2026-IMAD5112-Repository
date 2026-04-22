package com.example.parkingcalculatorg1

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

        // edittexts
        val txtWeekday = findViewById<EditText>(R.id.txtWeekday)
        val txtParkingType = findViewById<EditText>(R.id.txtParkingType)

        // buttons
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnReset.setOnClickListener {
            // clears the inputs
            txtWeekday.text.clear()
            txtParkingType.text.clear()
            // clears the outputs
            lblOutput.text = ""
        }

        btnSubmit.setOnClickListener {
            var dayOfWeek = txtWeekday.text.toString()
            var parkingType = txtParkingType.text.toString()

            // we convert to lowercase, to make sure that no matter how the user types
            // monday, the if statement still works (Monday, mOnday, MONDAY, monDAY)
            if (dayOfWeek.lowercase() == "monday") {
                lblOutput.text = "Parking is R5 an hour"
            } else if (dayOfWeek.lowercase() == "tuesday") {
                lblOutput.text = "Parking is FREE on Tuesday"
            } else if (dayOfWeek.lowercase() == "wednesday") {
                lblOutput.text = "Parking is R10 an hour"
            } else if (dayOfWeek.lowercase() == "thursday") {
                lblOutput.text = "Parking is R2 an hour"
            } else if (dayOfWeek.lowercase() == "friday") {
                lblOutput.text = "Parking is R5 an hour"
                // if we want to check 2 or more things in the same line, we use || or &&
                // if we use ||, it is like the word OR, if we use &&, it means AND
            } else if (dayOfWeek.lowercase() == "saturday" || dayOfWeek.lowercase() == "sunday") {
                lblOutput.text = "FREE PARKING ON WEEKENDS!"
            } else if (dayOfWeek == "") {
                lblOutput.text = "You entered no day of the week. Please enter something like Monday"
            } else {
                lblOutput.text = "You entered an INVALID day of the week. Please enter something like Monday"
            }
            // added a comment
            // add another commen
            if (parkingType.lowercase() == "student") {
                lblOutput.text = "You are not allowed to park in walmer park. Get out!"
            }
        }
    }



}
