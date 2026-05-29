package com.example.recap2g1

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

        // arrays for the items
        var studentNumbers : Array<String?> = arrayOfNulls(10)
        var studentMarks : Array<Double?> = arrayOfNulls(10) // double because numbers
        var studentsAdded = 0

        // btnDone passes through the arrays to the final screen for calculation purposes
        btnDoneS2.setOnClickListener {
            val screen3 = Intent(this, Screen3::class.java)
            screen3.putExtra("studentNumbers", studentNumbers)
            screen3.putExtra("studentMarks", studentMarks)
            startActivity(screen3)
        }

        //btnAdd saves the student and their mark into the arrays
        btnAddS2.setOnClickListener {
            if (studentsAdded >= 10) {
                Toast.makeText(this, "Array full", Toast.LENGTH_SHORT).show()
            } else {
                val studentNumber = txtStudentNumberS2.text.toString()
                val studentMark = txtFinalMarkS2.text.toString().toDouble() // don't forget toDouble()

                if (studentNumber == "") {
                    Toast.makeText(this, "Enter St#", Toast.LENGTH_SHORT).show()
                } else if (studentMark !in 0.0..100.0) {
                    Toast.makeText(this, "Invalid Mark", Toast.LENGTH_SHORT).show()
                } else {
                    studentNumbers[studentsAdded] = studentNumber
                    studentMarks[studentsAdded] = studentMark
                    Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show()
                    studentsAdded++
                }
            }
        }
    }
}