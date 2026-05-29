package com.example.recap2g2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //text views
        val lblHeadingS2 = findViewById<TextView>(R.id.lblHeadingS2)
        val lblStudentNumberS2 = findViewById<TextView>(R.id.lblStudentNumberS2)
        val lblFinalMarkS2 = findViewById<TextView>(R.id.lblFInalMarkS2)
        // edit texts
        val txtStudentNumberS2 = findViewById<EditText>(R.id.txtStudentNumberS2)
        val txtFinalMarkS2 = findViewById<EditText>(R.id.txtFinalMarkS2)
        // buttons
        val btnAddS2 = findViewById<Button>(R.id.btnAddS2)
        val btnDoneS2 = findViewById<Button>(R.id.btnDoneS2)

        // declaring arrays to hold the student numbers and marks
        var studentNumbers : Array<String?> = arrayOfNulls(10)
        // Int - number with NO decimals; Double - number WITH decimals
        var studentMarks : Array<Double?> = arrayOfNulls(10)
        var studentsAdded = 0

        // btnAdd will add new students and their marks into the appropriate arrays
        btnAddS2.setOnClickListener {
            // check if the array is full or not
            if (studentsAdded >= 10) {
                Toast.makeText(this, "Array full", Toast.LENGTH_SHORT).show()
            } else {
                // assign inputs to variables
                val studentNumber = txtStudentNumberS2.text.toString()
                val studentMark = txtFinalMarkS2.text.toString().toDouble() // don't forget toDouble

                // perform error checks / input validations
                if (studentNumber == "") {
                    Toast.makeText(this, "Invalid st#", Toast.LENGTH_SHORT).show()
                } else if (studentMark !in 0.0 .. 100.0) {
                    Toast.makeText(this, "Invalid mark", Toast.LENGTH_SHORT).show()
                } else {
                    studentMarks[studentsAdded] = studentMark
                    studentNumbers[studentsAdded] = studentNumber
                    studentsAdded++
                    Toast.makeText(this, "Student added", Toast.LENGTH_SHORT).show()
                }
            }
        }
        // btnDone will create an intent to go to Screen3, and pass the arrays for calculations
        btnDoneS2.setOnClickListener {
            val screen3 = Intent(this, Screen3::class.java)
            screen3.putExtra("studentNumbers", studentNumbers)
            screen3.putExtra("studentMarks", studentMarks)
            startActivity(screen3)
        }
    }
}