package com.example.training.domain.usecase

import com.example.training.core.common.Response
import com.example.training.data.repository.ProductRepositoryImpl
import com.example.training.domain.model.Product
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(MockitoExtension::class)
class GetProductListUseCaseTest {

    private lateinit var repository: ProductRepositoryImpl
    private lateinit var useCase: GetProductListUseCase
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        repository = mock()
        useCase = GetProductListUseCase(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `invoke emits Loading and Success when repository returns data`() = runTest {
        // Given
        val productList = listOf(Product(id = 1, image = "", title = "Test Product", description = ""))
        `when`(repository.getProductList()).thenReturn(productList)

        // When
        val emissions = useCase().toList()

        // Then
        assert(emissions[0] is Response.Loading)
        assert(emissions[1] is Response.Success)
        assertEquals(productList, (emissions[1] as Response.Success).data)
    }
}