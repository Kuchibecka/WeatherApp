package com.kuchibecka.weatherapp.dataClasses

data class ForecastData(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)