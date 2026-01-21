package com.application.amd_project.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.amd_project.R
import com.application.amd_project.models.Shoe

class CartAdapter(
    private val cartItems: MutableList<Shoe>,
    private val onItemRemoved: () -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val shoe = cartItems[position]

        holder.tvName.text = shoe.name
        holder.tvPrice.text = "₹${shoe.price}"

        // Load image (placeholder for now)
        holder.imgShoe.setImageResource(R.drawable.sneakspotlight)

        holder.btnDelete.setOnClickListener {
            cartItems.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)
            onItemRemoved()
        }
    }

    override fun getItemCount(): Int = cartItems.size

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgShoe: ImageView = itemView.findViewById(R.id.imgShoe)
        val tvName: TextView = itemView.findViewById(R.id.tvShoeName)
        val tvPrice: TextView = itemView.findViewById(R.id.tvShoePrice)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
    }
}
