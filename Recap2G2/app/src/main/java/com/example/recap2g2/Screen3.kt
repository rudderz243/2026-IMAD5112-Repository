package com.example.recap2g2

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

        // pull in arrays from screen2
        var studentNumbers = intent.getStringArrayExtra("studentNumbers")
        // IMPORTANT - getDoubleArrayExtra does not work the correct way in new versions
        // we have to use getSerializableExtra to accept our Array<Double?>
        var studentMarks = intent.getSerializableExtra("studentMarks") as? Array<Double?>
        // outputString stores our output as we work
        var outputString = ""

        // btnAll will display in the output a list of ALL students, and their corresponding marks
        btnAllS3.setOnClickListener {
            outputString = "List of all students:"
            // loop through each and every student in the arrays
            for (student in 0 until studentNumbers!!.size) {
                // assign each value to a local variable
                val studentNumber = studentNumbers?.get(student)
                val studentMark = studentMarks?.get(student)
                // add to the outputString
                outputString += "\nSt#: $studentNumber - $studentMark %"
            }
            // once we have looped through each and every student, we display the final outputString
            lblOutputS3.text = outputString
        }
        // a function allows us to split a snippet of code into something that can be reused in many places
        // a function has 4 main things, a declaration, inputs, instructions/code, and a return value
        // 1: declaration - the line that describes the function (so the name, inputs, and type)
        // 2: inputs - these are any values that the function will use to do its job
        // 3: instructions/code - this is the code that the function will run (similar to onClick)
        // 4: return value - this is what the function gives BACK to us in the code
        fun calculateAverage(markArray : Array<Double>) : Double {
            var totalSum = 0.0
            val numberOfItems = markArray.size
            // in order to get the total sum, we must add each and every mark together using a loop
            for (mark in 0 until numberOfItems) {
                totalSum += markArray[mark]
            }
            // calculate the average
            val average = totalSum / numberOfItems
            // the final line of every function is the "return" line, we use it to pass the value back
            return average
        }
        // btnAverage will use our function to calculate the average, and display it
        btnAverageS3.setOnClickListener {
            val calculatedAverage = calculateAverage(studentMarks as Array<Double>)
            lblOutputS3.text = "The calculated average is: $calculatedAverage"
        }
        // btnMaxMin will find the highest and the lowest values in the array
        btnMaxMinS3.setOnClickListener {
            // we get the first object in our array of marks
            val firstElement = studentMarks!![0]
            // and set it as the starting point for our maximum and minimum values (as it is both the
            // largest and smallest element we've seen so far)
            var max = firstElement
            var min = firstElement
            // we need to loop through every mark in the mark array, to find out which is the highest and lowest
            for (mark in 0 until studentMarks.size) {
                // fetches the mark we want to compare from the array
                val currentMark = studentMarks[mark]
                // we then compare this mark against the current highest and lowest, to see if it will take
                // their place or not
                if (currentMark!! < min!!) {
                    min = currentMark
                }
                if (currentMark!! > max!!) {
                    max = currentMark
                }
            }
            lblOutputS3.text = "Lowest Mark - $min %\nHighest Mark = $max %"
        }
        //btnClone closes the application
        btnCloseS3.setOnClickListener {
            finishAffinity()
        }
    }
}