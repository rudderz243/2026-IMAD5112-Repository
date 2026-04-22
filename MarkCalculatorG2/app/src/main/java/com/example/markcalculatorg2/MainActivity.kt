package com.example.markcalculatorg2

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

        // edittexts (number : signed)
        val txtMark1 = findViewById<EditText>(R.id.txtMark1)
        val txtMark2 = findViewById<EditText>(R.id.txtMark2)
        val txtMark3 = findViewById<EditText>(R.id.txtMark3)
        val txtMarkIce = findViewById<EditText>(R.id.txtMarkIce)

        // buttons
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnReset.setOnClickListener {
            // clears the inputs
            txtMark1.text.clear()
            txtMark2.text.clear()
            txtMark3.text.clear()
            txtMarkIce.text.clear()
            // clear the outputs
            lblOutput.text = ""
        }
        btnCalculate.setOnClickListener {
            var mark1 = txtMark1.text.toString().toDouble()
            var mark2 = txtMark2.text.toString().toDouble()
            var mark3 = txtMark3.text.toString().toDouble()
            var markIce = txtMarkIce.text.toString().toDouble()
            // mark 1 (assignment 1) counts 25%, ass 2 counts 30%, summative 35%, ice 10%
            val finalMark = (mark1*0.25) + (mark2*0.30) + (mark3*0.35) + (markIce*0.10)

            when {
                finalMark < 50 -> lblOutput.text = "F ${finalMark}"
                finalMark >= 50 && finalMark <= 74 -> lblOutput.text = "P {$finalMark}"
                finalMark >= 75 -> lblOutput.text = "PD ${finalMark}"
                finalMark < 0 -> lblOutput.text = "Invalid marks have been entered."
            }

            if (finalMark < 50) {
                lblOutput.text = "F ${finalMark}"
            } else if (finalMark >= 50 && finalMark <= 74) {
                lblOutput.text = "P {$finalMark}"
            } else if (finalMark >= 75) {
                lblOutput.text = "PD ${finalMark}"
            } else if (finalMark < 0) {
                lblOutput.text = "Invalid marks have been entered."
            }
        }
    }
}