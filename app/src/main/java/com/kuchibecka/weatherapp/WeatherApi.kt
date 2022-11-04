package com.kuchibecka.weatherapp

import com.kuchibecka.weatherapp.Data.ForecastDayData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("/v1/forecast.json")
    /*TODO: suspend*/ fun getWeekForecast(
        @Query("key") key: String,
        @Query("q") city: String,
        @Query("days") days: String = "7",
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): Response<List<ForecastDayData>>
}