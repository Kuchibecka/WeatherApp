package com.kuchibecka.weatherapp.screens.mainScreenFragments

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.kuchibecka.weatherapp.dataClasses.forecast.ForecastData

@Composable
fun TodayWeatherFragment(forecast: ForecastData/*, todayWeatherLogo: Int*/) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image( //TODO: mb replace with Icon()
            painter = rememberAsyncImagePainter("https:${forecast.forecast.forecastday[0].day.condition.icon}"),
            contentDescription = "weather logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Avg temp: ${forecast.forecast.forecastday[0].day.avgtemp_c} °C\n" +
                    "Max temp: ${forecast.forecast.forecastday[0].day.maxtemp_c} °C\n" +
                    "Min temp: ${forecast.forecast.forecastday[0].day.mintemp_c} °C\n",
            color = Color.White.copy(alpha = 0.8f)
        )
    }
}