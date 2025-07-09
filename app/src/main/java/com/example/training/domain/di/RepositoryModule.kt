package com.example.training.domain.di

import com.example.training.data.network.ApiService
import com.example.training.data.repository.ProductRepositoryImpl
import com.example.training.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideProductRepository(apiService: ApiService): ProductRepository {
     return   ProductRepositoryImpl(apiService = apiService)
    }
}