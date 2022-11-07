package com.kuchibecka.weatherapp.screens.mainScreenElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kuchibecka.weatherapp.dataClasses.forecast.Forecast

@Composable
@ExperimentalMaterial3Api
fun WeekWeather(weekForecast: Forecast) {
    // Bottom with week weather
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.SpaceEvenly,
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