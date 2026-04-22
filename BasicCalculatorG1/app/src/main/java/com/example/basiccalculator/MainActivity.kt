package com.example.basiccalculator

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
        // we start after this bracket
        // inputs
        var txtFirstNumber = findViewById<EditText>(R.id.txtFirstNumber)
        var txtSecondNumber = findViewById<EditText>(R.id.txtSecondNumber)
        //buttons
        var btnAdd = findViewById<Button>(R.id.btnAdd)
        var btnSubtract = findViewById<Button>(R.id.btnSubtract)
        var btnMultiply = findViewById<Button>(R.id.btnMultiply)
        var btnDivide = findViewById<Button>(R.id.btnDivide)
        // output
        var lblOutput = findViewById<TextView>(R.id.lblOutput)

        btnAdd.setOnClickListener {
            // INT MEANS NUMBER
            // STRING can be anything!
            val numOne : Int = txtFirstNumber.text.toString().toInt()
            val numTwo : Int = txtSecondNumber.text.toString().toInt()

            val sum = numOne + numTwo

            // display the answer back to the user
            lblOutput.text = "Answer: ${sum}"
        }
        btnSubtract.setOnClickListener {
            // INT MEANS NUMBER
            // STRING can be anything!
            val numOne : Int = txtFirstNumber.text.toString().toInt()
            val numTwo : Int = txtSecondNumber.text.toString().toInt()

            val sum = numOne - numTwo

            // display the answer back to the user
            lblOutput.text = "Answer: ${sum}"
        }
        btnMultiply.setOnClickListener {
            // INT MEANS NUMBER
            // STRING can be anything!
            val numOne : Int = txtFirstNumber.text.toString().toInt()
            val numTwo : Int = txtSecondNumber.text.toString().toInt()

            val sum = numOne * numTwo

            // display the answer back to the user
            lblOutput.text = "Answer: ${sum}"
        }
        btnDivide.setOnClickListener {
            // INT MEANS NUMBER
            // STRING can be anything!
            val numOne : Int = txtFirstNumber.text.toString().toInt()
            val numTwo : Int = txtSecondNumber.text.toString().toInt()

            val sum = numOne / numTwo

            // display the answer back to the user
            lblOutput.text = "Answer: ${sum}"
        }
        // linking the button on the screen to our code
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnReset.setOnClickListener {
            // inputs have a built-in .clear() function
            txtFirstNumber.text.clear()
            txtSecondNumber.text.clear()
            // outputs we need to clear manually
            lblOutput.text = ""
        }
    }
}