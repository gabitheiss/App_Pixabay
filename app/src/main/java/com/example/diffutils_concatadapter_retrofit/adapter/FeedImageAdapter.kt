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

class FeedImageAdapter : ListAdapter<Image, FeedViewHolder>(ImagesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.itens_image_list, parent, false).apply {
            return FeedViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        getItem(position).let { image ->
            holder.bind(image)
        }
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