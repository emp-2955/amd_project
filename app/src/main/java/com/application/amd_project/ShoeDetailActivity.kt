package com.application.amd_project

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.application.amd_project.models.Shoe

class ShoeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoe_detail)


        val imgShoe = findViewById<ImageView>(R.id.imgShoe)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvPrice = findViewById<TextView>(R.id.tvPrice)
        val tvCategory = findViewById<TextView>(R.id.tvCategory)
        val sizeContainer = findViewById<LinearLayout>(R.id.sizeContainer)

        tvName.text = Shoe.name
        tvPrice.text = "₹${Shoe.price}"
        tvCategory.text = "${Shoe.gender} • ${shoe.category}"

        // Load image (use Glide)
       //TODO

        // Add sizes dynamically
        for (size in shoe.sizes) {
            val textView = TextView(this).apply {
                text = size.toString()
                setPadding(32, 16, 32, 16)
                setBackgroundResource(android.R.drawable.btn_default)
                setTextColor(Color.BLACK)
            }
            sizeContainer.addView(textView)
        }
    }
}
