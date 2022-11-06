package com.kuchibecka.weatherapp.network

import com.kuchibecka.weatherapp.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getForecast(
        key: String,
        city: String,
        days: String = "7",
        aqi: String = "no",
        alerts: String = "no"
    ) = apiService.getForecast(key, city, days, aqi, alerts)
}