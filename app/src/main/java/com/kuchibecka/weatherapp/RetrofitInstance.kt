package com.kuchibecka.weatherapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: WeatherAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/forecast.json")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherAPI::class.java)
    }
}