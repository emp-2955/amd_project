package com.application.amd_project

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.amd_project.R
import com.google.firebase.firestore.FirebaseFirestore

class ProductListActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_GENDER = "gender"
        const val EXTRA_CATEGORY = "category"
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var shoeAdapter: ShoeAdapter
    private val shoeList = mutableListOf<Shoe>()

    private lateinit var gender: String
    private lateinit var category: String

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        gender = intent.getStringExtra(EXTRA_GENDER) ?: ""
        category = intent.getStringExtra(EXTRA_CATEGORY) ?: ""

        recyclerView = findViewById(R.id.recyclerShoes)

        setupRecyclerView()
        fetchShoesFromFirebase()
    }

    private fun setupRecyclerView() {
        val spanCount = if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) 2 else 1

        recyclerView.layoutManager = GridLayoutManager(this, spanCount)
        recyclerView.setHasFixedSize(true)

        shoeAdapter = ShoeAdapter(shoeList, gender)
        recyclerView.adapter = shoeAdapter
    }

    private fun fetchShoesFromFirebase() {
        db.collection("shoes")
            .whereEqualTo("gender", gender)
            .whereEqualTo("category", category)
            .get()
            .addOnSuccessListener { documents ->
                shoeList.clear()
                for (doc in documents) {
                    val shoe = doc.toObject(Shoe::class.java)
                    shoeList.add(shoe)
                }
                shoeAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                Toast.makeText(
                    this,
                    "Failed to load shoes",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}
