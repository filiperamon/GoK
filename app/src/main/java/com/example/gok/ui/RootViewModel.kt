package com.example.gok.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gok.data.RootProductsResult
import com.example.gok.data.model.RootResponse
import com.example.gok.data.repository.GokApiDataSource
import com.example.gok.data.repository.GokRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RootViewModel(private val dataSource: GokRepository) : ViewModel() {

    val rootResponseLiveData: MutableLiveData<RootResponse> = MutableLiveData()
    val serverErrorLiveData: MutableLiveData<String> = MutableLiveData()

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            dataSource.getProducts { result: RootProductsResult ->
                when (result) {
                    is RootProductsResult.Success -> {
                        rootResponseLiveData.value = result.rootResult
                    }
                    is RootProductsResult.Error -> {
                        serverErrorLiveData.value = result.error
                    }
                }
            }
        }
    }

}