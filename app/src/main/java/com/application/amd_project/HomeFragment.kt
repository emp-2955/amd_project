package com.application.amd_project

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.amd_project.adapter.ShoeAdapter
import com.application.amd_project.models.Shoe


class HomeFragment : Fragment() {

    private lateinit var rvMen: RecyclerView
    private lateinit var rvWomen: RecyclerView
    private lateinit var rvKids: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        rvMen = view.findViewById(R.id.rvMen)
        rvWomen = view.findViewById(R.id.rvWomen)
        rvKids = view.findViewById(R.id.rvKids)

        setupRecyclerViews()

        return view
    }

    private fun setupRecyclerViews() {

        rvMen.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvWomen.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvKids.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val menShoes = listOf(
            Shoe("Nike Air Max", 4999, "men", "casual", listOf(7,8,9), ""),
            Shoe("Adidas Ultraboost", 5999, "men", "sports", listOf(8,9,10), "")
        )

        val womenShoes = listOf(
            Shoe("Puma Diva", 3999, "women", "casual", listOf(5,6,7), ""),
            Shoe("Nike Flex", 4599, "women", "sports", listOf(6,7,8), "")
        )

        val kidsShoes = listOf(
            Shoe("Kids Runner", 1999, "kids", "casual", listOf(1,2,3), ""),
            Shoe("Mini Sneaker", 1799, "kids", "sports", listOf(2,3,4), "")
        )

        rvMen.adapter = ShoeAdapter(menShoes) { openShoeDetail(it) }
        rvWomen.adapter = ShoeAdapter(womenShoes) { openShoeDetail(it) }
        rvKids.adapter = ShoeAdapter(kidsShoes) { openShoeDetail(it) }
    }

    private fun openShoeDetail(shoe: Shoe) {
        val intent = Intent(requireContext(), ShoeDetailActivity::class.java)
        intent.putExtra("shoe", shoe)
        startActivity(intent)
    }


}
