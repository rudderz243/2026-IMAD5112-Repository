package com.example.parkingcalculatorg2

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
            // clear our inputs
            txtWeekday.text.clear()
            txtParkingType.text.clear()
            // clear the outputs
            lblOutput.text = ""
        }

        btnSubmit.setOnClickListener {
            var dayOfWeek = txtWeekday.text.toString()
            var parkingType = txtParkingType.text.toString()

            // we convert the users input to lowercase, to make sure that we always get a match
            // by making it lowercase, even if they enter monDAY, mOnDaY, MONDAY or any other variant,
            // it will still match
            if (dayOfWeek.lowercase() == "monday") {
                lblOutput.text = "Parking is R5 an hour"
            // in Kotlin, we can use the AND, as well as the OR operators when we are writing logic
            // with OR, only one needs to be true, and it is written as ||
            // with AND, both or ALL need to be true, and it is written as &&
            } else if (dayOfWeek.lowercase() == "tuesday" || dayOfWeek.lowercase() == "thursday") {
                lblOutput.text = "Parking is FREE on Tuesdays and Thursdays!"
            } else if (dayOfWeek.lowercase() == "wednesday") {
                lblOutput.text = "Parking is R2 an hour"
            } else if (dayOfWeek.lowercase() == "friday") {
                lblOutput.text = "Parking is R10 an hour"
            } else if (dayOfWeek.lowercase() == "saturday" || dayOfWeek.lowercase() == "sunday") {
                lblOutput.text = "Parking is FREE on weekends"
            } else if (dayOfWeek == "") {
                lblOutput.text = "Please enter a valid day of the week, e.g. 'monday'"
            } else {
                lblOutput.text = "Invalid input, please enter a valid day of the week!"
            }

            when {
                dayOfWeek == "monday" -> lblOutput.text = "Parking is R5 an hour"
                dayOfWeek == "tuesday" || dayOfWeek == "thursday" -> lblOutput.text = "Parking is FREE on Tuesdays and Thursdays!"
                dayOfWeek == "wednesday" -> lblOutput.text = "Parking is R2 an hour"
                dayOfWeek == "friday" -> lblOutput.text = "Parking is R10 an hour"
                dayOfWeek == "saturday" || dayOfWeek == "sunday" -> lblOutput.text = "Parking is FREE on weekends"
                dayOfWeek == "" -> lblOutput.text = "Please enter a valid day of the week, e.g. 'monday'"
                else -> lblOutput.text = "Invalid input, please enter a valid day of the week!"
            }


            if (parkingType.lowercase() == "student") {
                lblOutput.text = "You are banned from walmer park parking lot!!!!"
            }


            // added a whole bunch of new code
            // aslkjdlkasjdlaskjd
            // ashdakjsdhaskjk
        }

    }
}