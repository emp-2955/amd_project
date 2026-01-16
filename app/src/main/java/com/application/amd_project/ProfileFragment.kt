package com.application.amd_project

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.yourpackage.app.ui.orders.OrderDetailsActivity

class ProfileFragment : Fragment() {

    private lateinit var listOrders: ListView
    private lateinit var tvEditProfile: TextView
    private lateinit var tvSavedAddress: TextView
    private lateinit var btnSignOut: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Initialize views
        listOrders = view.findViewById(R.id.listOrders)
        tvEditProfile = view.findViewById(R.id.tvEditProfile)
        tvSavedAddress = view.findViewById(R.id.tvSavedAddress)
        btnSignOut = view.findViewById(R.id.btnSignOut)

        setupOrders()
        setupClicks()

        return view
    }

    private fun setupOrders() {
        // Dummy orders for now (replace with Firebase later)
        val orders = listOf(
            "Order #1001 - Delivered",
            "Order #1002 - On the way",
            "Order #1003 - Cancelled"
        )

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            orders
        )

        listOrders.adapter = adapter

        listOrders.setOnItemClickListener { _, _, position, _ ->
            val selectedOrder = orders[position]

            // Open Order Details screen
            val intent = Intent(requireContext(), OrderDetailsActivity::class.java)
            intent.putExtra("order_name", selectedOrder)
            startActivity(intent)
        }
    }

    private fun setupClicks() {

        tvEditProfile.setOnClickListener {
            startActivity(
                Intent(requireContext(), EditProfileActivity::class.java)
            )
        }

        tvSavedAddress.setOnClickListener {
            startActivity(
                Intent(requireContext(), SavedAddressActivity::class.java)
            )
        }

        btnSignOut.setOnClickListener {
            // Firebase sign out can be added here later
            // FirebaseAuth.getInstance().signOut()

            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
