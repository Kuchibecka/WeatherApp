package com.kuchibecka.weatherapp.network

import android.app.appsearch.SearchResult
import com.kuchibecka.weatherapp.dataClasses.forecast.ForecastData
import com.kuchibecka.weatherapp.dataClasses.search.SearchResultItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v1/forecast.json")
    suspend fun getForecast(
        @Query("key") key: String,
        @Query("q") city: String,
        @Query("days") days: String = "7",
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): Response<ForecastData>

    @GET("/v1/search.json")
    suspend fun getSearch(
        @Query("key") key: String,
        @Query("q") searchRequest: String
    ): Response<ArrayList<SearchResultItem>>
}