package com.yourpackage.shoesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.amd_project.R
import com.application.amd_project.models.Shoe

class ShoeAdapter(
    private val shoes: List<Shoe>,
    private val gender: String
) : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {

        val layoutRes = when (gender.lowercase()) {
            "men" -> R.layout.item_shoe_men
            "women" -> R.layout.item_shoe_women
            else -> R.layout.item_shoe_kids
        }

        val view = LayoutInflater.from(parent.context)
            .inflate(layoutRes, parent, false)

        return ShoeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe = shoes[position]

        holder.txtName.text = shoe.name
        holder.txtPrice.text = "₹${shoe.price}"

        // Sizes shown as text (simple & clean)
        if (holder.txtSizes != null && shoe.sizes.isNotEmpty()) {
            holder.txtSizes.text = "Sizes: " + shoe.sizes.joinToString(", ")
        }
    }

    override fun getItemCount(): Int = shoes.size

    class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)

        // Optional (only if present in XML)
        val txtSizes: TextView? = itemView.findViewById(R.id.txtSizes)
    }
}
