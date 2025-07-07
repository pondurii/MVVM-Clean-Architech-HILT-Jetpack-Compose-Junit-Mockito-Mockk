package com.example.training.domain.repository

import com.example.training.domain.model.Product
import com.example.training.domain.model.ProductDetail
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProductList() : List<Product>

    suspend fun getProductDetail(id : String) : ProductDetail
}