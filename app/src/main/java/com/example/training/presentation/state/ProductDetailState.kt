package com.example.training.presentation.state

import com.example.training.domain.model.ProductDetail


data class ProductDetailState(val isLoading : Boolean = false,
                              val data : ProductDetail? = null,
                              var error : String ="")