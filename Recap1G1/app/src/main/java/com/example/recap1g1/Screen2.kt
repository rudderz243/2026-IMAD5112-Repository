package com.example.recap1g1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
        // text views
        val lblHeadingS2 = findViewById<TextView>(R.id.lblHeadingS2)
        // edit texts
        val txtNameS2 = findViewById<EditText>(R.id.txtNameS2)
        val txtNumberS2 = findViewById<EditText>(R.id.txtNumberS2)
        // buttons
        val btnAddS2 = findViewById<Button>(R.id.btnAddS2)
        val btnDoneS2 = findViewById<Button>(R.id.btnDoneS2)

        // arrays to store item information
        var itemNames : Array<String?> = arrayOfNulls(10)
        var itemCounts : Array<Int?> = arrayOfNulls(10)
        var itemsAdded = 0
        // we turn off the "done" button until the user has added all the required items
        btnDoneS2.isEnabled = false

        btnDoneS2.setOnClickListener {
            val screen3 = Intent(this, Screen3::class.java)
            screen3.putExtra("itemNames", itemNames)
            screen3.putExtra("itemCounts", itemCounts)
            startActivity(screen3)
        }
        btnAddS2.setOnClickListener {
            if (itemsAdded >= 10) {
                Toast.makeText(this, "There is no more space in the array.", Toast.LENGTH_SHORT).show()
                btnAddS2.isEnabled = false
            } else {
                val name = txtNameS2.text.toString()
                val quantity = txtNumberS2.text.toString().toInt()
                var validInputs = false
                // we check to make sure that the user has actually entered an item name
                if (name == "") {
                    Toast.makeText(this, "Please enter a valid item name", Toast.LENGTH_SHORT).show()
                // we verify that the number entered is within our valid range of 0 and 20
                } else if (quantity <= 0 || quantity > 20) {
                    Toast.makeText(this, "Please enter a number greater than 0 and less than 20", Toast.LENGTH_SHORT).show()
                } else {
                    validInputs = true
                }

                // based on whether the validInputs variable is true or false, we either add the item to the array, or don't
                if (validInputs) {
                    itemNames[itemsAdded] = name
                    itemCounts[itemsAdded] = quantity
                    itemsAdded++
                } else {
                    Toast.makeText(this, "Item not added.", Toast.LENGTH_SHORT).show()
                }

            }
        }
     }
}