package com.kuchibecka.weatherapp.screens.mainScreenElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kuchibecka.weatherapp.dataClasses.forecast.Forecast

@Composable
@ExperimentalMaterialApi
fun WeekWeather(weekForecast: Forecast) {
    // Bottom with week weather
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(
            weekForecast.forecastday
        ) { _, dayForecast ->
            //TODO: заменить на класс погоды на день (лого погоды, ветер (направление + скорость), температура)
            WeekWeatherItem(dayForecast)
        }
    }
}