package com.example.diffutils_concatadapter_retrofit.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.diffutils_concatadapter_retrofit.model.Image

open class ImagesDiffCallback() : DiffUtil.ItemCallback<Image>() {

    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.id == newItem.id
    }


}