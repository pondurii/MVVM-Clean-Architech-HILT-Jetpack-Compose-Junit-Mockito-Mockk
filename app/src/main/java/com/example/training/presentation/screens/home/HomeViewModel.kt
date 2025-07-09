package com.example.training.presentation.screens.home


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.training.core.common.Response
import com.example.training.domain.usecase.GetProductListUseCase
import com.example.training.presentation.state.ProductListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getProductsUseCase: GetProductListUseCase) :
    ViewModel() {

    private val _productList = MutableStateFlow(ProductListState())
    val productList: StateFlow<ProductListState> = _productList

    fun getProducts() {
        getProductsUseCase.invoke().onEach {
            when (it) {
                is Response.Loading -> {
                    _productList.value = ProductListState(isLoading = true)
                }

                is Response.Success -> {
                    _productList.value = ProductListState(data = it.data)
                }

                is Response.Error -> {
                    _productList.value = ProductListState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}