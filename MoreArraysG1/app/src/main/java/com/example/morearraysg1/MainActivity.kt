package com.example.morearraysg1

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
        // text views
        val lblHeading = findViewById<TextView>(R.id.lblHeading)
        val lblName = findViewById<TextView>(R.id.lblName)
        val lblPrice = findViewById<TextView>(R.id.lblPrice)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)
        val lblSearch = findViewById<TextView>(R.id.lblSearch)

        // edit texts
        val txtName = findViewById<EditText>(R.id.txtName)
        val txtPrice = findViewById<EditText>(R.id.txtPrice)
        val txtSearch = findViewById<EditText>(R.id.txtSearch)

        // buttons
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSearch = findViewById<Button>(R.id.btnSearch)

        var itemNames : Array<String?> = arrayOfNulls(5)
        var itemPrices : Array<Int?> = arrayOfNulls(5)
        var itemsAdded = 0
        // we start off with empty arrays (there are no items/objects inside of them), but even though they
        // are empty, they have a fixed size (a limit) to how many things they can hold. we, as developers,
        // need to keep track of how much we add, so that we do not try and overfill the array

        btnAdd.setOnClickListener {
            if (itemsAdded >= 5) {
                // if we have added the max amount of items, we do not want them to be able to add any more
                lblOutput.text = "The array is full."
                btnAdd.isEnabled = false
            } else {
                // otherwise, we add like normal
                val itemName = txtName.text.toString()
                val itemPrice = txtPrice.text.toString().toInt()
                // we add it to the next open space in the array
                itemNames[itemsAdded] = itemName
                itemPrices[itemsAdded] = itemPrice
                // we then update the counter (to keep track of how much space is left)
                itemsAdded++
            }
        }

        btnSearch.setOnClickListener {
            // loop through entire array
            for (counter in 0 until itemNames.size) {
                if (itemNames[counter] == null) {
                    // if we reach a "null" or empty space in the array, we know we've reached the end
                    // of the items we've added, so we can exit the loop and stop checking for a match
                    lblOutput.text = "Item not found in array!"
                    break
                }
                val searchTerm = txtSearch.text.toString().lowercase()
                if (itemNames[counter]?.lowercase() == searchTerm) {
                    // if we find the item, we print out the item name and price, then exit the loop
                    lblOutput.text = "Item found! ${itemNames[counter]} - ${itemPrices[counter]}"
                    break
                }
            }
            // if we reach the end of the loop without getting a match, or running out of spaces to check,
            // we can print out the same error
            lblOutput.text = "Item not found in array!"
        }

    }
}