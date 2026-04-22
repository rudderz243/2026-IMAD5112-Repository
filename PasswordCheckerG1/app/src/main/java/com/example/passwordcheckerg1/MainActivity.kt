package com.example.passwordcheckerg1

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
        // start after this bracket

        // textviews
        val lblHeading = findViewById<TextView>(R.id.lblHeading)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        // edittexts
        val txtInput = findViewById<EditText>(R.id.txtInput)

        // buttons
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnReset.setOnClickListener {
            // clear the input
            txtInput.text.clear()
            // clear the output
            lblOutput.text = ""
        }

        btnSubmit.setOnClickListener {
            // get the the password from the user
            var password = txtInput.text.toString()
            // our two correct passwords
            val correctPassword = "123abc"
            val secondPassword = "cba321"

            // if statement to check if the password entered was correct
            if (password == correctPassword) {
                lblOutput.text = "You have entered the correct password!"
            } else if (password == secondPassword) {
                lblOutput.text = "You have entered the super secret second password!"
            // if none of the if statements matched, else will run.
            } else {
                lblOutput.text = "You have entered an INCORRECT password."
            }
        }
    }
}