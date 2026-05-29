package com.example.recap1g2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // text views
        val lblHeadingS3 = findViewById<TextView>(R.id.lblHeadingS3)
        val lblOutputS3 = findViewById<TextView>(R.id.lblOutputS3)
        // buttons
        val btnCloseS3 = findViewById<Button>(R.id.btnCloseS3)
        val btnShowS3 = findViewById<Button>(R.id.btnShowS3)

        btnCloseS3.setOnClickListener {
            finishAffinity()
        }

        btnShowS3.setOnClickListener {
            // fetching items from screen2
            var itemNames = intent.getStringArrayExtra("itemNames")
            var itemQuantities = intent.getIntArrayExtra("itemQuantities")
            // output text variable to build our output in the loop
            var outputText = ""
            // loop through each item in the array
            // the double !! means that we understand if we typed the name wrong in the getExtra, we will get NOTHING
            for (items in 0 until itemNames!!.size) {
                val name = itemNames?.get(items)
                val quantity = itemQuantities?.get(items)
                outputText += "${name} - ${quantity}"
            }
            // display output
            lblOutputS3.text = outputText
        }
    }
}