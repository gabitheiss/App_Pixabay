package com.example.diffutils_concatadapter_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutils_concatadapter_retrofit.R
import com.example.diffutils_concatadapter_retrofit.databinding.AdsItemBinding

class AdsAdapter : RecyclerView.Adapter<AdsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.ads_item,parent,false).apply {
            return AdsViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: AdsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 1
}

class AdsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    private val binding : AdsItemBinding = AdsItemBinding.bind(itemView)

}