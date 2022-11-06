package com.kuchibecka.weatherapp.dataClasses.forecast

data class ForecastData(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)