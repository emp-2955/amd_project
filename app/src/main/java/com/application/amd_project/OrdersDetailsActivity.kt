package com.yourpackage.app.ui.orders

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.application.amd_project.R
import com.yourpackage.app.R

class OrderDetailsActivity : AppCompatActivity() {

    private lateinit var tvOrderId: TextView
    private lateinit var tvOrderStatus: TextView
    private lateinit var tvOrderItems: TextView
    private lateinit var tvOrderTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        tvOrderId = findViewById(R.id.tvOrderId)
        tvOrderStatus = findViewById(R.id.tvOrderStatus)
        tvOrderItems = findViewById(R.id.tvOrderItems)
        tvOrderTotal = findViewById(R.id.tvOrderTotal)

        loadOrderDetails()
    }

    private fun loadOrderDetails() {
        val orderData = intent.getStringExtra("order_name") ?: "Order #0000 - Unknown"

        // Example: "Order #1001 - Delivered"
        val parts = orderData.split(" - ")

        tvOrderId.text = parts[0]
        tvOrderStatus.text = if (parts.size > 1) parts[1] else "Processing"

        // Dummy data (replace with Firebase)
        tvOrderItems.text = """
            • Nike Air Zoom
            • Adidas Ultraboost
        """.trimIndent()

        tvOrderTotal.text = "Total: ₹4,999"
    }
}
