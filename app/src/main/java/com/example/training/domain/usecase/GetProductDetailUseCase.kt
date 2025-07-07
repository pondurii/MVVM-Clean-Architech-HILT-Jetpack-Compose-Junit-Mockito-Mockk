package com.example.training.domain.usecase

import com.example.training.core.common.Response
import com.example.training.data.repository.ProductRepositoryImpl
import com.example.training.domain.model.ProductDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(private val repositoryImpl : ProductRepositoryImpl)  {

    operator fun invoke(id : String) : Flow<Response<ProductDetail>> = flow {
        emit(Response.Loading())
        try {
            emit(Response.Success(data = repositoryImpl.getProductDetail(id)))
        }catch (e : Exception){
            emit(Response.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}