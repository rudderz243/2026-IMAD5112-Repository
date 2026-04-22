package com.example.screensandloopsg1

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

        btnClose.setOnClickListener {
            // to exit the app, we need to close ALL open screens, and then the app
            // to do this, we use a special command called finishAffinity()
            finishAffinity()
        }

        btnShow.setOnClickListener {
            // we get the user inputs from the textboxes
            val multiple = txtMultiple.text.toString().toInt()
            val endNumber = txtEnd.text.toString().toInt()
            // we make the intent (route) to the next screen
            val screen2 = Intent(this, Screen2::class.java)
            // next, we need to pass the values across from this screen to the next one
            // we do this using a method called "putExtra", because we are putting extra
            // information into the route to the new screen (into our intent)
            screen2.putExtra("multiple", multiple)
            screen2.putExtra("endNumber", endNumber)
            // then we go to the second screen
            startActivity(screen2)
        }
    }
}