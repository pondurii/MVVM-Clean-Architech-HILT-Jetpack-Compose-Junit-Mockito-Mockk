package com.example.training.data.repository

import com.example.training.core.common.toProductDetail
import com.example.training.core.common.toProductList
import com.example.training.data.network.ApiService
import com.example.training.domain.model.Product
import com.example.training.domain.model.ProductDetail
import com.example.training.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService) : ProductRepository {

    override suspend fun getProductList(): List<Product> {
        return apiService.getAllProductListAPI().map { it.toProductList() }
    }

    override suspend fun getProductDetail(id: String): ProductDetail {
        return apiService.getProductDetailsAPI(id).toProductDetail()
    }
}