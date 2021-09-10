package com.example.diffutils_concatadapter_retrofit.services

import com.example.diffutils_concatadapter_retrofit.BuildConfig
import com.example.diffutils_concatadapter_retrofit.model.PixabayImages
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesEndpoint {

    @GET("/api/")
    suspend fun fetchImages(@Query("key") key : String = BuildConfig.API_KEY,
                            @Query("q") q : String,
                            @Query("lang") lang : String = "pt") : Response<PixabayImages>
}