package com.myprojects.gifapp.di

import retrofit2.Retrofit

object InjectionHelper {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http")
            .build()
    }
}