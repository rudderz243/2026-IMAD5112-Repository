package com.example.recap1g2

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
        val txtQuantityS2 = findViewById<EditText>(R.id.txtQuantityS2)
        // buttons
        val btnAddS2 = findViewById<Button>(R.id.btnAddS2)
        val btnDoneS2 = findViewById<Button>(R.id.btnDoneS2)
        // arrays to store the packing information
        var itemNames : Array<String?> = arrayOfNulls(10)
        var itemQuantities : Array<Int?> = arrayOfNulls(10)
        var itemCount = 0
        
        btnDoneS2.setOnClickListener {
            val screen3 = Intent(this, Screen3::class.java)
            screen3.putExtra("itemNames", itemNames)
            screen3.putExtra("itemQuantities", itemQuantities)
            startActivity(screen3)
        }
        // we stop the user from going to the next screen until they've added all the required items
        btnDoneS2.isEnabled = false

        btnAddS2.setOnClickListener {
            // check if there are still places in the array to add items
            if (itemCount >= 10) {
                btnAddS2.isEnabled = false
                btnDoneS2.isEnabled = true
                Toast.makeText(this, "The array is full.", Toast.LENGTH_SHORT).show()
            } else {
                val name = txtNameS2.text.toString()
                val quantity = txtQuantityS2.text.toString().toInt()
                // create a variable to hold whether the inputs are valid or not
                var validInputs = false
                // we first check if the user has entered a name for the item
                if (name == "") {
                    Toast.makeText(this, "Enter a valid name.", Toast.LENGTH_SHORT).show()
                // next we check if the number entered is bigger than 0 and less than 20
                } else if (quantity <= 0 || quantity > 20) {
                    Toast.makeText(this, "Enter a quantity between 0 and 20", Toast.LENGTH_SHORT)
                        .show()
                    // otherwise, if both inputs are valid, we set the variable to true
                } else {
                    validInputs = true
                }
                if (validInputs) {
                    itemNames[itemCount] = name
                    itemQuantities[itemCount] = quantity
                    itemCount++
                    Toast.makeText(this, "Item saved.", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}