package com.example.morearraysg2

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

        // we need to declare our arrays next, however this time instead of providing the values in the code,
        // our arrays will start off empty, and we will add the items as we gi
        var itemNames : Array<String?> = arrayOfNulls(5)
        var itemPrices : Array<Int?> = arrayOfNulls(5)
        // we also need a variable to keep track of how much we've added to the empty arrays
        var numberOfItemsAdded = 0


        // the add button will allow us to add new entries / items into the array
        btnAdd.setOnClickListener {
            // first, we need to check if there is space for the new item in the arrays
            if (numberOfItemsAdded >= 5) {
                // tell the user there is no more space for new items
                lblOutput.text = "The array is full, no new items can be added."
            } else {
                // otherwise, if there is space, we get the values for the new item, and add them to the array
                val newName = txtName.text.toString()
                val newPrice = txtPrice.text.toString().toInt()
                // we then add them to the next available empty space in the array
                itemNames[numberOfItemsAdded] = newName
                itemPrices[numberOfItemsAdded] = newPrice
                // and keep track of what the new next empty space is
                numberOfItemsAdded++
            }
        }
        // the search button allows us to look for a specific item in the array
        btnSearch.setOnClickListener {
            // we need a variable to keep track of whether the item has been found or not
            var foundSearchItem = false
            // then, we need a loop to go through each and every item in the array
            for (items in 0 until itemNames.size) {
                // the first thing we check for, is whether the item we are checking, actually has data
                if (itemNames[items] == null) {
                    // because the array is empty from this point onwards, we exit the loop
                    break
                }
                // next, if the item is NOT blank, we check if it matches what we are searching for
                val searchTerm = txtSearch.text.toString().lowercase()
                val currentItem = itemNames[items]?.lowercase()
                if (currentItem == searchTerm) {
                    foundSearchItem = true
                    lblOutput.text = "Found! The price for ${itemNames[items]} is ${itemPrices[items]}."
                    break
                }
            }
            if (foundSearchItem == false) { // print out the appropriate error if we don't find the item
                lblOutput.text = "Could not find the item in the array."
            }
        }

    }
}