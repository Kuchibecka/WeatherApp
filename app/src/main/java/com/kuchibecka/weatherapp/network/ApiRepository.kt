package com.kuchibecka.weatherapp.network

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getForecast(
        key: String,
        city: String,
        days: String = "7",
        aqi: String = "no",
        alerts: String = "no"
    ) = apiService.getForecast(key, city, days, aqi, alerts)

    suspend fun getSearch(
        key: String,
        searchRequest: String
    ) = apiService.getSearch(key, searchRequest)
}