package com.kuchibecka.weatherapp

/**
 * Data-class with forecast for 1 day
 *
 * @param cityName - name of the city for which we got the forecast
 * @param dateTime - forecast datetime
 * @param weatherType - type of weather (e.g. sunny/rainy/cloudy etc)
 * @param imageUrl - URL to image icon
 * @param currentTemp - current temperature
 * @param minTemp - minimum day temperature
 * @param maxTemp - maximum day temperature
 * @param hourWeatherForecast - forecast for each hour of the day
 * @param windDirection - direction of wind
 * @param windVelocity - velocity of wind
 */
data class DayForecastData(
    val cityName: String,
    val dateTime: String,
    val weatherType: String,
    val imageUrl: String,
    val currentTemp: String,
    val minTemp: String,
    val maxTemp: String,
    val hourWeatherForecast: String,
    val windDirection: String,
    val windVelocity: String
)
