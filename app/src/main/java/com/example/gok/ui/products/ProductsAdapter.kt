package com.example.gok.ui.products

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gok.R
import com.example.gok.data.model.ProductResponse

class ProductsAdapter(
    private val context: Context,
    private val productsList: List<ProductResponse>) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent,false)
        return ViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(productsList[position])
    }

    override fun getItemCount(): Int = productsList.count()

    class ViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view){
        private val imvUrl: ImageView = view.findViewById(R.id.imvUrl)
        private val mContext = context

        fun bindView(productResponse: ProductResponse) {
            Glide.with(mContext)
                .load(productResponse.imageUrl)
                .into(imvUrl)
        }
    }
}