package com.example.passcheckerg2

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

        // edittexts (number : signed)
        val txtMark = findViewById<EditText>(R.id.txtMark)

        // switch (ignore the yellow warning)
        val swGov = findViewById<Switch>(R.id.swGov)

        // button
        val btnCheck = findViewById<Button>(R.id.btnCheck)

        btnCheck.setOnClickListener {
            // double allows for numbers with decimal places
            val mark : Double = txtMark.text.toString().toDouble() // (SpongeBob SquarePants Official, 2025)
            // a boolean can only be one of two values. TRUE or FALSE
            val govPass : Boolean = swGov.isChecked // (w3schools, n.d.)

            // if the switch is checked / turned on
            if (govPass) {
                when { // (The IIE, 2026)
                    mark >= 30 -> lblOutput.text = "Congrats on the government pass! :)"
                    else -> lblOutput.text = "You did not pass :("
                }
            // else -> the switch is NOT checked / turned off
            } else {
                when {
                    mark >= 50 -> lblOutput.text = "Congrats on the standard pass! :)"
                    else -> lblOutput.text = "You did not pass :("
                }
            }
        }
    }
}
/*
Reference List:
SpongeBob SquarePants Official., 2025. 4 HOURS of SpongeBob 🧽 | SpongeBob. [video online]
Available at: <https://www.youtube.com/watch?v=xRfwXBitjc8>
[Accessed 19 March 2026].

The IIE., 2026. Introduction to Mobile Application Development IMAD5112 Module Manual 2026. s.l.:s.p.

w3schools., n.d. Kotlin Booleans. [online]
Available at: <https://www.w3schools.com/kotlin/kotlin_booleans.php>
[Accessed 19 March 2026].
*/