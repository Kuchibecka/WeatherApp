package com.kuchibecka.weatherapp.screens.mainScreenFragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kuchibecka.weatherapp.dataClasses.Forecastday

@Composable
fun WeekWeatherItemFragment(dayForecast: Forecastday) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color.Transparent),
        shape = RoundedCornerShape(9.dp),
        elevation = 3.dp,
        backgroundColor = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.BottomCenter,
        ) {}
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.8f),
                            Color.Black
                        ),
                        startY = 10f
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Row(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(text = dayForecast.date, color = Color.White)
                /* TODO: fetch weather logos
                Image( //TODO: mb replace with Icon()
                    painter = painterResource(id = dayWeatherLogo),
                    contentDescription = "weather logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(64.dp)
                )
                */
                Text(text = "${dayForecast.day.avgtemp_c}°C", color = Color.White.copy(alpha = 0.8f))
                Text(text = "${dayForecast.day.maxwind_kph} km/h", color = Color.White.copy(alpha = 0.8f))
            }
        }
    }
}