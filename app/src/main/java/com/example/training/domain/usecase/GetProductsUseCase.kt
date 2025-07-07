package com.example.training.domain.usecase

import com.example.training.core.common.Response
import com.example.training.data.repository.ProductRepositoryImpl
import com.example.training.domain.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(private val repositoryImpl : ProductRepositoryImpl)  {

    operator fun invoke() : Flow<Response<List<Product>>> = flow {
        emit(Response.Loading())
        try {
            emit(Response.Success(data = repositoryImpl.getProductList()))
        }catch (e : Exception){
            emit(Response.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}
