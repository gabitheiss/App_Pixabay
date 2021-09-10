package com.example.diffutils_concatadapter_retrofit.model

import com.google.gson.annotations.SerializedName

data class PixabayImages(

    @SerializedName("hits") val hist : List<Image>
)

data class Image(
    val id : Int,
    val tags: String,
    val previewURL: String,
    val largeImageURL: String,
    val fullHDURL: String,
    val imageURL: String,
    val user: String,
    val userImageURL: String,
)
