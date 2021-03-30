package com.example.gok

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gok.ui.RootViewModel
import com.example.gok.ui.products.ProductsAdapter
import com.example.gok.ui.spotlight.SpotlightAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: RootViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleSpotlight: RecyclerView = findViewById(R.id.rcSpotlight)
        val recycleProducts: RecyclerView = findViewById(R.id.rcProducts)

        val txtCashTitle: TextView = findViewById(R.id.txtTitleCash)
        val txtTitleProducts: TextView = findViewById(R.id.txtTitleProducts)
        val imgCashUrl: ImageView = findViewById(R.id.imvCashUrl)

        viewModel.rootResponseLiveData.observe(this, { response ->

            recycleSpotlight.apply {
                layoutManager = LinearLayoutManager(returnContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = SpotlightAdapter(returnContext(), response.spotlight)
            }

            response.cash.let {
                txtCashTitle.text = response.cash.title
                Glide.with(this)
                    .load(response.cash.bannerUrl)
                    .into(imgCashUrl)
            }

            recycleProducts.apply {
                layoutManager = LinearLayoutManager(returnContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = ProductsAdapter(returnContext(), response.products)
            }

            txtTitleProducts.text = getString(R.string.productsTitle)
        })

        viewModel.serverErrorLiveData.observe(this, { error ->
            Toast.makeText(returnContext() ,error, Toast.LENGTH_SHORT).show()
        })

        viewModel.getProducts()
    } 

    private fun returnContext(): Context = this
}