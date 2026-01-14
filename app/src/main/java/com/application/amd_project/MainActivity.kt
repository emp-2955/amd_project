package com.application.amd_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMen = findViewById<Button>(R.id.btnMen)
        val btnWomen = findViewById<Button>(R.id.btnWomen)
        val btnKids = findViewById<Button>(R.id.btnKids)

        btnMen.setOnClickListener {
            openCategoryScreen("men")
        }

        btnWomen.setOnClickListener {
            openCategoryScreen("women")
        }

        btnKids.setOnClickListener {
            openCategoryScreen("kids")
        }
    }

    private fun openCategoryScreen(gender: String) {
        val intent = Intent(this, CategoryActivity::class.java).apply {
            putExtra("gender", gender)
        }
        startActivity(intent)
    }
}
