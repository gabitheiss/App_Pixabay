package com.example.diffutils_concatadapter_retrofit.di

import com.example.diffutils_concatadapter_retrofit.services.ImagesEndpoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pixabay.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesPixabayApi(retrofit: Retrofit) : ImagesEndpoint =
        retrofit.create(ImagesEndpoint::class.java)

}