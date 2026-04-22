package com.example.screensandloopsg1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
        // textviews
        val lblHeadingScreen2 = findViewById<TextView>(R.id.lblHeadingScreen2)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        // button
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        // on the sending screen: we use putExtra to ADD the information
        // on the receiving screen: we use getExtra to GET the information
        // for text: getStringExtra(), for numbers: getIntExtra(), for booleans: getBoolExtra()
        val multiple = intent.getIntExtra("multiple", 0)
        val endNumber = intent.getIntExtra("endNumber", 0)
        // our output string holds ALL of the multiples in the timestable, it grows in the loop
        var outputString = ""
        // the loop will run from 0 until the ending number the user has entered
        for (counter in 0..endNumber) {
            // every time the loop runs, we calculate the result of the multiplication sum
            val sum = counter * multiple
            // and add the appropriate line to our timestable
            outputString += "$counter x $multiple = $sum \n"
        }
        // finally, we display the end result to the user
        lblOutput.text = outputString
    }
}