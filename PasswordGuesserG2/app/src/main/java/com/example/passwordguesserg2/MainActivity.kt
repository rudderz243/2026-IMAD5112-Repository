package com.example.passwordguesserg2

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
        // start working from here
        // textviews
        val lblHeading = findViewById<TextView>(R.id.lblHeading)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        // edittexts
        val txtInput = findViewById<EditText>(R.id.txtInput)

        // buttons
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnReset.setOnClickListener {
            // reset button is always the same
            // . clear() on all inputs, = "" on all outputs
            txtInput.text.clear()
            lblOutput.text = ""
        }

        btnSubmit.setOnClickListener {
            // first, we get the user input
            var passwordGuess = txtInput.text.toString()

            val firstPassword = "123abc"
            val secondPassword = "secret"

            if (passwordGuess == firstPassword) {
                // this will run if the guess matches the FIRST password
                lblOutput.text = "You have guessed the password!"
            } else if (passwordGuess == secondPassword) {
                // this will run if the guess matches the SECOND password
                lblOutput.text = "You've guessed the super secret second password!"
            } else {
                // this will run if the guess matches NONE of the passwords
                lblOutput.text = "Invalid password. Guess again!"
            }
        }

    }
}