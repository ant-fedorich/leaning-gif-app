package com.myprojects.gifapp.di

import com.myprojects.gifapp.retrofit.GifRetrofitApiService
import com.myprojects.gifapp.util.AppConsts.GIPHY_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InjectionHelper {
    fun provideGifRetrofitClient(): Retrofit = Retrofit.Builder()
            .baseUrl(GIPHY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun provideGifRetrofitApiService(retrofitClient: Retrofit): GifRetrofitApiService
            = retrofitClient.create(GifRetrofitApiService::class.java)
}