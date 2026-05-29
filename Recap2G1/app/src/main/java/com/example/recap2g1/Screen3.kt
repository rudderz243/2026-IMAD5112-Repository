package com.example.recap2g1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // text views
        val lblHeadingS3 = findViewById<TextView>(R.id.lblHeadingS3)
        val lblOutputS3 = findViewById<TextView>(R.id.lblOutputS3)
        // buttons
        val btnAllS3 = findViewById<Button>(R.id.btnAllS3)
        val btnAverageS3 = findViewById<Button>(R.id.btnAverageS3)
        val btnMaxMinS3 = findViewById<Button>(R.id.btnMaxMinS3)
        val btnCloseS3 = findViewById<Button>(R.id.btnCloseS3)

        // get the arrays from screen 2
        var studentNumbers = intent.getStringArrayExtra("studentNumbers")
        var studentMarks = intent.getDoubleArrayExtra("studentMarks")
        // variable to hold our output as we go
        var outputString = ""

        // btnAll shows us all the students and their corresponding marks
        btnAllS3.setOnClickListener {
            outputString = "Full Class List\n"
            for (student in 0 until studentNumbers!!.size) {
                val studentNumber = studentNumbers?.get(student)
                val studentMark = studentMarks?.get(student)
                outputString += "\n$studentNumber - $studentMarks %"
            }
            lblOutputS3.text = outputString
        }

        // to calculate the average, we will use something called a function
        // a function consists of 3 important things: a list of inputs, a set of instructions, and a return value
        // inputs - they are what the function takes IN, and they can be whatever you want
        // instructions - these are just lines of code, similar to what we do in the OnClick methods of buttons
        // retun value - is what the function gives back after doing all of the instructions
        fun calculateAverage(markArray : DoubleArray) : Double {
            var totalSum = 0.0
            var numberOfItems = markArray.size
            // to get the total sum, we add all the marks together
            for (mark in 0 until numberOfItems) {
                totalSum += markArray[mark]
            }
            // when we say the word "return", that means we are FINISHED with the function, and it will pass back
            // whatever we tell it to
            return totalSum/numberOfItems
        }
        // btnAverage uses our average method to calculate the average
        btnAverageS3.setOnClickListener {
            val calculatedAverage = calculateAverage(studentMarks!!)
            lblOutputS3.text = "Average - $calculatedAverage"
        }
        // btnMaxMin calculates the maximum and minimum marks from the array
        btnMaxMinS3.setOnClickListener {
            // we set the min and the max to the first item in the array, because 0 would cause issues with min
            val firstElement = studentMarks!![0]
            var min = firstElement
            var max = firstElement
            // loop through the array and check each element
            for (mark in 0 until studentMarks.size) {
                val currentMarkInArray = studentMarks[mark]
                // check if the next mark is lower than the previous
                if (currentMarkInArray < min) {
                    min = currentMarkInArray
                }
                // check if the next mark is higher than the previous
                if (currentMarkInArray > max) {
                    max = currentMarkInArray
                }
            }
            lblOutputS3.text = "Lowest Mark: $min\nHighest Mark: $max"
        }
        //btnClose exits the application
        btnCloseS3.setOnClickListener {
            finishAffinity()
        }

    }
}