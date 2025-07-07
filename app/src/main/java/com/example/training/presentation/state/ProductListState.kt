package com.example.training.presentation.state

import com.example.training.domain.model.Product

data class ProductListState(
    val isLoading: Boolean = false,
    val data: List<Product>? = null,
    var error: String = ""
)