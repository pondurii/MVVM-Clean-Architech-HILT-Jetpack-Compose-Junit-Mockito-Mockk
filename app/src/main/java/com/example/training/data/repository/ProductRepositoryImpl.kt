package com.example.training.data.repository

import com.example.training.core.common.toProductDetail
import com.example.training.core.common.toProductList
import com.example.training.data.network.ApiService
import com.example.training.domain.model.Product
import com.example.training.domain.model.ProductDetail
import com.example.training.domain.repository.ProductRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService) : ProductRepository {

/*    private val fakeProducts = listOf(
        Product("1", "Laptop Pro", "High-performance laptop", 1299.99, "https://via.placeholder.com/150/FF0000/FFFFFF?Text=Laptop"),
        Product("2", "Wireless Mouse", "Ergonomic wireless mouse", 25.50, "https://via.placeholder.com/150/00FF00/FFFFFF?Text=Mouse"),
        Product("3", "Keyboard XL", "Mechanical keyboard", 75.00, "https://via.placeholder.com/150/0000FF/FFFFFF?Text=Keyboard"),
        Product("4", "Monitor 27\"", "27-inch 4K Monitor", 399.00, "https://via.placeholder.com/150/FFFF00/000000?Text=Monitor"),
        Product("5", "Webcam HD", "1080p HD Webcam", 49.99) // No image for one
    )

    override fun getProducts(): Flow<List<Product>> = flow {
        delay(1500)
        emit(fakeProducts)
    }*/

    override suspend fun getProductList(): List<Product> {
        return apiService.getAllProductListAPI().map { it.toProductList() }
    }

    override suspend fun getProductDetail(id: String): ProductDetail {
        return apiService.getProductDetailsAPI(id).toProductDetail()
    }
}