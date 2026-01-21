package com.application.amd_project.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.application.amd_project.R
import com.application.amd_project.adapter.CartAdapter
import com.application.amd_project.models.Shoe

class CartFragment : Fragment() {

    private lateinit var rvCart: RecyclerView
    private lateinit var tvTotalPrice: TextView
    private lateinit var btnPlaceOrder: Button

    // Temporary cart data (later replace with Firebase / ViewModel)
    private val cartItems = mutableListOf<Shoe>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        rvCart = view.findViewById(R.id.rvCart)
        tvTotalPrice = view.findViewById(R.id.tvTotalPrice)
        btnPlaceOrder = view.findViewById(R.id.btnPlaceOrder)

        setupRecyclerView()
        calculateTotal()

        btnPlaceOrder.setOnClickListener {
            // TODO: Navigate to order summary / checkout
        }

        return view
    }

    private fun setupRecyclerView() {
        rvCart.layoutManager = LinearLayoutManager(requireContext())
        rvCart.adapter = CartAdapter(cartItems) {
            calculateTotal()
        }
    }



    private fun calculateTotal() {
        val total = cartItems.sumOf { it.price }
        tvTotalPrice.text = "₹$total"

        btnPlaceOrder.isEnabled = cartItems.isNotEmpty()
    }
}
