package com.example.basiccalculatorg2

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
        // we start below this bracket
        // inputs
        val txtFirstNumber = findViewById<EditText>(R.id.txtFirstNumber)
        val txtSecondNumber = findViewById<EditText>(R.id.txtSecondNumber)
        // buttons
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        // output
        val lblOutput = findViewById<TextView>(R.id.lblOutput)
        // setOnClickListener allows us to give instructions to run, when button is pressed
        btnAdd.setOnClickListener {
            // Int = number
            // String = anything
            val numOne : Int =  txtFirstNumber.text.toString().toInt()
            val numTwo : Int = txtSecondNumber.text.toString().toInt()

            val sum = numOne + numTwo

            lblOutput.text = "Answer:" + sum.toString()
            lblOutput.text = "Answer: ${sum}"
        }
        btnSubtract.setOnClickListener {
            // Int = number
            // String = anything
            val numOne : Int =  txtFirstNumber.text.toString().toInt()
            val numTwo : Int = txtSecondNumber.text.toString().toInt()

            val sum = numOne - numTwo

            lblOutput.text = "Answer:" + sum.toString()
            lblOutput.text = "Answer: ${sum}"
        }
        btnMultiply.setOnClickListener {
            // Int = number
            // String = anything
            val numOne : Int =  txtFirstNumber.text.toString().toInt()
            val numTwo : Int = txtSecondNumber.text.toString().toInt()

            val sum = numOne * numTwo

            lblOutput.text = "Answer:" + sum.toString()
            lblOutput.text = "Answer: ${sum}"
        }
        btnDivide.setOnClickListener {
            // Int = number
            // String = anything
            val numOne : Int =  txtFirstNumber.text.toString().toInt()
            val numTwo : Int = txtSecondNumber.text.toString().toInt()

            val sum = numOne / numTwo

            lblOutput.text = "Answer:" + sum.toString()
            lblOutput.text = "Answer: ${sum}"
        }
        // call in the button the same way we called in all the other UI components
        val btnReset = findViewById<Button>(R.id.btnReset)
        // instructions to run when the button is clicked
        btnReset.setOnClickListener {
            // clear the inputs
            txtFirstNumber.text.clear()
            txtSecondNumber.text.clear()
            // clear the outputs
            lblOutput.text = ""
        }
    }
}