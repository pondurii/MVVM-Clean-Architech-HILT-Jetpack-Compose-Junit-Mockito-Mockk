package com.example.training.core.common

import com.example.training.data.models.ProductListDTO
import com.example.training.domain.model.Product
import com.example.training.domain.model.ProductDetail

fun ProductListDTO.toProductList(): Product {
    return Product(
        id = this.id,
        image = this.image,
        title = this.title,
        description = this.description
    )
}

fun ProductListDTO.toProductDetail(): ProductDetail {
    return ProductDetail(
        category = this.category,
        description = this.description,
        id = this.id,
        image = this.image,
        price = this.price,
        title = this.title
    )
}