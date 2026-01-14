package com.yourpackage.shoesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.application.amd_project.R

class CategoryActivity : ComponentActivity() {

    companion object {
        const val EXTRA_GENDER = "gender"
        const val EXTRA_CATEGORY = "category"
    }

    private lateinit var gender: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        gender = intent.getStringExtra(EXTRA_GENDER) ?: ""

        val btnCasual = findViewById<Button>(R.id.btnCasual)
        val btnFormal = findViewById<Button>(R.id.btnFormal)
        val btnSports = findViewById<Button>(R.id.btnSports)

        btnCasual.setOnClickListener {
            openProductList("casual")
        }

        btnFormal.setOnClickListener {
            openProductList("formal")
        }

        btnSports.setOnClickListener {
            openProductList("sports")
        }
    }

    private fun openProductList(category: String) {
        val intent = Intent(this, ProductListActivity::class.java).apply {
            putExtra(EXTRA_GENDER, gender)
            putExtra(EXTRA_CATEGORY, category)
        }
        startActivity(intent)
    }
}
