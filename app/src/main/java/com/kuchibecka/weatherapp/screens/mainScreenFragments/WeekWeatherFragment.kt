package com.kuchibecka.weatherapp.screens.mainScreenFragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kuchibecka.weatherapp.R
import com.kuchibecka.weatherapp.dataClasses.Forecast
import com.kuchibecka.weatherapp.dataClasses.Forecastday

@Composable
fun WeekWeatherFragment(weekForecast: Forecast) {
    // Bottom with week weather
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        itemsIndexed(
            weekForecast.forecastday
        ) { _, dayForecast ->
            //TODO: заменить на класс погоды на день (лого погоды, ветер (направление + скорость), температура)
            WeekWeatherItemFragment(dayForecast)
        }
    }
}