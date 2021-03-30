package com.example.gok.ui

import android.R
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.gok.data.RootProductsResult
import com.example.gok.data.model.CashResponse
import com.example.gok.data.model.ProductResponse
import com.example.gok.data.model.RootResponse
import com.example.gok.data.model.SpotlightResponse
import com.example.gok.data.repository.GokRepository
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.invoke
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.*


@RunWith(MockitoJUnitRunner::class)
class RootViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var rootResponseLiveDataObserver: Observer<RootResponse>

    private lateinit var viewModel: RootViewModel


    @Test
    fun `when view model getProducts get success then sets rootResponseLiveData`() {

        val spotlight = listOf(
            SpotlightResponse(
                name = "Sport", bannerUrl = "banner.jpg", description = "description"
            )
        )

        val products = listOf(
            ProductResponse(
                name = "Product 1", imageUrl = "image.jpg", description = "description product"
            )
        )

        val cash = CashResponse(
            title = "title cash", bannerUrl = "banner.jpg", "description cash"
        )

        val rootResponse = RootResponse(
            spotlight = spotlight,
            products = products,
            cash = cash
        )

        val resultSuccess = MockRepository(RootProductsResult.Success(rootResponse))
        viewModel = RootViewModel(resultSuccess)
        viewModel.rootResponseLiveData.observeForever(rootResponseLiveDataObserver)

        viewModel.getProducts()

        verify(rootResponseLiveDataObserver).onChanged(rootResponse)
    }
}

class MockRepository(private val result: RootProductsResult): GokRepository {
    override fun getProducts(productsResultCallBack: (result: RootProductsResult) -> Unit) {
        productsResultCallBack(result)
    }
}