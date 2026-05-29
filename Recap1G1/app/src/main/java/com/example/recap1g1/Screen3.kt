package com.example.recap1g1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        val btnViewS3 = findViewById<Button>(R.id.btnViewS3)

        btnCloseS3.setOnClickListener {
            finishAffinity()
        }

        btnViewS3.setOnClickListener {
            // fetch the arrays
            var itemNames = intent.getStringArrayExtra("itemNames")
            var itemCounts = intent.getIntArrayExtra("itemCounts")
            // output string for displaying all the item information
            var outputString = ""
            // we use the !! to tell Kotlin that we understand if we typed the array name wrong, it will
            // be = null (not be able to find it)
            for (item in 0 until itemNames!!.size) {
                val name = itemNames[item]
                val count = itemNames[item]
                outputString += "${name} - ${count}"
            }
            // print out the items added to the string once we've added everything in the loop
            lblOutputS3.text = outputString
        }
    }
}