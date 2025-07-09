package com.example.training.data.network

import com.example.training.data.models.ProductListDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/v1/ba83287f-3a51-4878-8502-5e0f5fe898fe")
    suspend fun getAllProductListAPI() : List<ProductListDTO>

    @GET("/products/{Id}")
    suspend fun getProductDetailsAPI(@Path("Id") id : String) : ProductListDTO

}