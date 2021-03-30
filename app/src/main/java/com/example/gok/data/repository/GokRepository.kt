package com.example.gok.data.repository

import com.example.gok.data.RootProductsResult

interface GokRepository {
    fun getProducts(productsResultCallBack: (result: RootProductsResult) -> Unit)
}