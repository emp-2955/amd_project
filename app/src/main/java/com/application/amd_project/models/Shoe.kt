package com.application.amd_project.models
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    val name: String = "",
    val price: Int = 0,
    val gender: String = "",
    val category: String = "",
    val sizes: List<Int> = emptyList(),
    val imageUrl: String = ""
) : Parcelable