package com.example.passcheckerg1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
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

        // edittext
        val txtMark = findViewById<EditText>(R.id.txtMark)

        // switch
        val swGov = findViewById<Switch>(R.id.swGov)

        // button
        val btnCheck = findViewById<Button>(R.id.btnCheck)

        btnCheck.setOnClickListener {
            // double means it can have decimal places
            val mark : Double = txtMark.text.toString().toDouble()
            // boolean can only be one of two things: TRUE or FALSE
            val govPass : Boolean = swGov.isChecked

            if (govPass) {
                // what we do if the switch is turned on
                when { // (The Independent Institute of Education, 2026)
                    mark >= 30 -> lblOutput.text = "Congrats on the government pass!"
                    else -> lblOutput.text = "You did not pass :("
                }
            } else {
                // what we do if the switch is turned off
                when {
                    mark >= 50 -> lblOutput.text = "Congrats on the pass!"
                    else -> lblOutput.text = "You did not pass :("
                }
            }
        }
    }
}
// REFERENCE LIST
// The Independent Institute of Education., 2026. Introduction to Mobile Application Development IMAD5112 Module Manual 2026. s.l.:s.p.