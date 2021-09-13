package com.example.diffutils_concatadapter_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.diffutils_concatadapter_retrofit.R
import com.example.diffutils_concatadapter_retrofit.databinding.ItensImageListBinding
import com.example.diffutils_concatadapter_retrofit.model.Image


const val NORMAL_VIEW = 0
const val ADS_VIEW = 1

class FeedImageAdapter : ListAdapter<Image, RecyclerView.ViewHolder>(ImagesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == ADS_VIEW){
            LayoutInflater.from(parent.context).inflate(R.layout.ads_item,parent,false).apply {
                return AdsViewHolder(this)
            }
        }
        LayoutInflater.from(parent.context).inflate(R.layout.itens_image_list,parent,false).apply {
            return FeedViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == NORMAL_VIEW){
            holder as FeedViewHolder
            getItem(position).let {image ->
            holder.bind(image)
            }
        }else{
            holder as AdsViewHolder
        }
    }

    override fun getItemViewType(position: Int): Int {
        //a cada 2 fotos mostra 1 anuncio (resto divisão)
        return if (position % 3 == 1) ADS_VIEW else NORMAL_VIEW
    }

}

class FeedViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val binding: ItensImageListBinding = ItensImageListBinding.bind(itemView)

    fun bind(image: Image) {
        binding.textViewName.text = image.user
        Glide.with(itemView).load(image.largeImageURL).into(binding.imageViewPhoto)
        Glide.with(itemView).load(image.userImageURL).into(binding.imageViewAvatar)
    }
}