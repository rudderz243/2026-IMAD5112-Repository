package com.example.markcalculatorg1

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
        // edittexts (number : decimals)
        val txtMark1 = findViewById<EditText>(R.id.txtMark1)
        val txtMark2 = findViewById<EditText>(R.id.txtMark2)
        val txtMark3 = findViewById<EditText>(R.id.txtMark3)
        val txtMarkIce = findViewById<EditText>(R.id.txtMarkIce)
        // buttons
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnReset.setOnClickListener {
            // clear the inputs
            txtMark1.text.clear()
            txtMark2.text.clear()
            txtMark3.text.clear()
            txtMarkIce.text.clear()
            // clear the outputs
            lblOutput.text = ""
        }

        btnCalculate.setOnClickListener {
            // we get all the marks from the user
            // double == number WITH decimals ; int == number with NO decimals
            val mark1 = txtMark1.text.toString().toDouble()
            val mark2 = txtMark2.text.toString().toDouble()
            val mark3 = txtMark3.text.toString().toDouble()
            val markIce = txtMarkIce.text.toString().toDouble()

            // assignment 1/test = 25% ; assignment 2 = 30% ; exam/summative = 35% ; ice = 10%
            var finalMark = (mark1 * 0.25) + (mark2 * 0.3) + (mark3 * 0.35) + (markIce * 0.1)

            when {
                finalMark >= 0 && finalMark < 50 -> lblOutput.text = "F - ${finalMark}"
                finalMark >= 50 && finalMark < 75 -> lblOutput.text = "P - ${finalMark}"
                finalMark >= 75 && finalMark <= 100 -> lblOutput.text = "PD - ${finalMark}"
                finalMark > 100 || finalMark < 0 -> lblOutput.text = "Invalid marks entered."
                else -> lblOutput.text = "Invalid marks entered."
            }

            if (finalMark >= 0 && finalMark < 50) {
                lblOutput.text = "F - ${finalMark}"
            } else if (finalMark >= 50 && finalMark < 75) {
                lblOutput.text = "P - ${finalMark}"
            } else if (finalMark >= 75 && finalMark <= 100) {
                lblOutput.text = "PD - ${finalMark}"
            } else if (finalMark > 100 || finalMark < 0) {
                lblOutput.text = "Invalid marks entered."
            } else {
                lblOutput.text = "Invalid marks entered."
            }
        }

    }
}