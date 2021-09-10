package com.example.diffutils_concatadapter_retrofit.repository

import com.example.diffutils_concatadapter_retrofit.model.Image
import com.example.diffutils_concatadapter_retrofit.services.ImagesEndpoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class PixabayRepository @Inject constructor(private val service : ImagesEndpoint) {


    suspend fun fetchImages(q:String) : List<Image>? {
        return withContext(Dispatchers.Default){
            val response = service.fetchImages(q=q)
            val processedResponse = processData(response)
            processedResponse?.hits
        }
    }
    private fun <T> processData(response: Response<T>) : T?{
        return if (response.isSuccessful) response.body()
        else null
    }

}