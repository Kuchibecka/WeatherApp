package com.kuchibecka.weatherapp.di

import com.kuchibecka.weatherapp.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    const val API_KEY = "93e8bb3d75904109905130630220311"

    @Provides
    fun baseUrl() = "https://api.weatherapi.com/v1/forecast.json/"

    @Provides
    @Singleton
    fun providerRetrofit(baseUrl: String) : ApiService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}