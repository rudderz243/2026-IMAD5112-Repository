package com.example.screensandloopsg2

import android.content.Intent
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

        // edittexts (number)
        val txtMultiple = findViewById<EditText>(R.id.txtMultiple)
        val txtEnd = findViewById<EditText>(R.id.txtEnd)

        // buttons
        val btnShow = findViewById<Button>(R.id.btnShow)
        val btnClose = findViewById<Button>(R.id.btnClose)

        btnShow.setOnClickListener {
            // get the user input
            val multiple = txtMultiple.text.toString().toInt()
            val endNumber = txtEnd.text.toString().toInt()

            // create a variable to hold our route to the second screen
            val screen2 = Intent(this, Screen2::class.java)
            // putExtra allows us to "put extra information" into our route, and this allows us to take
            // the value of variables on our current screen, along with us to screen 2
            screen2.putExtra("multiple", multiple)
            screen2.putExtra("endNumber", endNumber)
            // go to screen 2
            startActivity(screen2)
        }

        btnClose.setOnClickListener {
            // this app closes all open screens, and then exits the app
            finishAffinity()
        }

    }
}