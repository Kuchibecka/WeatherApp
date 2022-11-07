package com.kuchibecka.weatherapp.screens.mainScreenElements

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.kuchibecka.weatherapp.dataClasses.forecast.ForecastData

@Composable
fun TodayWeather(forecast: ForecastData/*, todayWeatherLogo: Int*/) {
    val superscript = SpanStyle(
        baselineShift = BaselineShift.Superscript,
        fontSize = 16.sp, // font size of superscript
        color = Color.Red // color
    )
    val subscript = SpanStyle(
        baselineShift = BaselineShift.Subscript,
        fontSize = 16.sp, // font size of subscript
        color = Color.Blue // color
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .fillMaxHeight()
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
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
                text = "{${forecast.forecast.forecastday[0].day.condition.text}}",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Text(
            text = buildAnnotatedString {
                append("Avg: ${forecast.forecast.forecastday[0].day.avgtemp_c}°C")
                withStyle(subscript) {
                    append("min: ${forecast.forecast.forecastday[0].day.mintemp_c}°C")
                }
                withStyle(superscript) {
                    append("max: ${forecast.forecast.forecastday[0].day.maxtemp_c}°C")
                }
            },
            style = MaterialTheme.typography.bodyLarge
        )
    }
}