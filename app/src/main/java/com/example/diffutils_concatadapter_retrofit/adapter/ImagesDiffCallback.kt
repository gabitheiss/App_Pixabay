package com.example.diffutils_concatadapter_retrofit.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.diffutils_concatadapter_retrofit.model.Image

open class ImagesDiffCallback(private val oldList: List<Image>,
                              private val newList: List<Image>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}