package com.example.gok.ui.spotlight

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gok.R
import com.example.gok.data.model.SpotlightResponse

class SpotlightAdapter(
    private val context: Context,
    private val spotlightList: List<SpotlightResponse>) :
    RecyclerView.Adapter<SpotlightAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_spotligh, parent,false)
        return ViewHolder(view, context)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(spotlightList[position])
    }

    override fun getItemCount(): Int = spotlightList.count()

    class ViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view){
        private val imvUrl: ImageView = view.findViewById(R.id.imvUrl)
        private val mContext = context

        fun bindView(spotlightResponse: SpotlightResponse) {
            Glide.with(mContext)
                .load(spotlightResponse.bannerUrl)
                .into(imvUrl)
        }
    }

}