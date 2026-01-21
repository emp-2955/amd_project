package com.application.amd_project

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.application.amd_project.models.Shoe

class ShoeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoe_detail)

        val shoe = intent.getParcelableExtra<Shoe>("shoe") ?: return



        val imgShoe = findViewById<ImageView>(R.id.imgShoe)
        val tvName = findViewById<TextView>(R.id.tvShoeName)
        val tvPrice = findViewById<TextView>(R.id.tvPrice)
        val sizeContainer = findViewById<RadioGroup>(R.id.rgSizes)

        tvName.text = shoe.name
        tvPrice.text = "₹${shoe.price}"

        // Add sizes dynamically as RadioButtons
        for (size in shoe.sizes) {
            val radioButton = RadioButton(this).apply {
                text = size.toString()
                id = size  // unique id
            }
            sizeContainer.addView(radioButton)
        }
    }



}
