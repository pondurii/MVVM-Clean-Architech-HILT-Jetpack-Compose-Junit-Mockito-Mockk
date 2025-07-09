package com.example.training.presentation.screens.home

import com.example.training.core.common.Response
import com.example.training.domain.model.Product
import com.example.training.domain.usecase.GetProductListUseCase
import com.example.training.presentation.state.ProductListState
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

class HomeViewModelTest {


    @Mock
    private lateinit var mockGetProductsUseCase: GetProductListUseCase

    private lateinit var viewModel: HomeViewModel

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher) // Use TestScope for more control if needed

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher) // Set main dispatcher for ViewModel's scope
        viewModel = HomeViewModel(mockGetProductsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun `getProducts success updates productList with data`() = testScope.runTest {
        // Arrange
        val mockProducts = listOf(
            Product(id = 1, title = "Product 1", description = "Desc 1", image = ""),
            Product(id = 2, title = "Product 2", description = "Desc 2", image = "")
        )
        val successResponse = flowOf(Response.Success(mockProducts))
        whenever(mockGetProductsUseCase.invoke()).thenReturn(successResponse)

        val collectedStates = mutableListOf<ProductListState>()
        val job = launch {
            viewModel.productList.collect { state ->
                collectedStates.add(state)
            }
        }

        // Act
        viewModel.getProducts()
        advanceUntilIdle()

        // Assert
        assertTrue("Initial state should be present", collectedStates.size >= 1)

        val finalState = collectedStates.last() // Get the last emitted state
        assertFalse(finalState.isLoading)
        assertEquals(mockProducts, finalState.data)
        assertTrue(finalState.error.isEmpty())
        job.cancel()
    }

}