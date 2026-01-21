package com.application.amd_project.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.amd_project.R
import com.application.amd_project.models.Shoe

class ShoeAdapter(
    private val shoes: List<Shoe>,
    private val onItemClick: (Shoe) -> Unit

) : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shoe, parent, false)
        return ShoeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe = shoes[position]

        holder.txtName.text = shoe.name
        holder.txtPrice.text = "₹${shoe.price}"

        holder.itemView.setOnClickListener {
            onItemClick(shoe)
        }
    }


    override fun getItemCount(): Int = shoes.size

    class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
    }
}
