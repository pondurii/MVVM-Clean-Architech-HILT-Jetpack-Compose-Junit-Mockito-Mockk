package com.example.training.domain.di

import com.example.training.data.repository.ProductRepositoryImpl
import com.example.training.domain.usecase.GetProductDetailUseCase
import com.example.training.domain.usecase.GetProductListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun productListUseCaseProvider(repositoryImpl: ProductRepositoryImpl) : GetProductListUseCase {
        return GetProductListUseCase(repositoryImpl)
    }

    @Provides
    @Singleton
    fun productDetailUseCaseProvider(repositoryImpl: ProductRepositoryImpl) : GetProductDetailUseCase {
        return GetProductDetailUseCase(repositoryImpl)
    }

}