package com.alekhya.shopeaseai.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alekhya.shopeaseai.R
import com.alekhya.shopeaseai.domain.Product
import com.alekhya.shopeaseai.presentation.home.components.ProductCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    var searchText by remember { mutableStateOf("") }

    val products = listOf(

        Product(
            id = 1,
            name = "Nike Running Shoes",
            price = 2999.0,
            rating = 4.8,
            imageRes = R.drawable.shoes,
            description = "Lightweight running shoes with breathable mesh upper."
        ),

        Product(
            id = 2,
            name = "Adidas T-Shirt",
            price = 1299.0,
            rating = 4.6,
            imageRes = R.drawable.shirts,
            description = "Comfortable cotton T-Shirt for daily wear."
        ),

        Product(
            id = 3,
            name = "Apple Watch",
            price = 45999.0,
            rating = 4.9,
            imageRes = R.drawable.watch,
            description = "Smartwatch with fitness tracking and health monitoring."
        ),

        Product(
            id = 4,
            name = "Puma Sneakers",
            price = 3499.0,
            rating = 4.5,
            imageRes = R.drawable.shoe,
            description = "Stylish sneakers designed for everyday comfort."
        ),

        Product(
            id = 5,
            name = "Samsung Earbuds",
            price = 5999.0,
            rating = 4.7,
            imageRes = R.drawable.earbuds,
            description = "Wireless earbuds with premium sound quality."
        )
    )

    val filteredProducts = products.filter {
        it.name.contains(searchText, ignoreCase = true)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "🛍 ShopEaseAI",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Search Products")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(filteredProducts) { product ->

                ProductCard(
                    product = product,
                    onAddToCart = {
                        // Cart functionality will be added later
                    }
                )
            }
        }
    }
}