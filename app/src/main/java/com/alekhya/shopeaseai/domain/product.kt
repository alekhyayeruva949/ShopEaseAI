package com.alekhya.shopeaseai.domain

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val rating: Double,
    val imageRes: Int,
    val description: String
)