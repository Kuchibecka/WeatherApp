package com.kuchibecka.weatherapp.screens.mainScreenElements

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.kuchibecka.weatherapp.dataClasses.forecast.Forecastday
import com.kuchibecka.weatherapp.ui.theme.Shapes

@ExperimentalMaterial3Api
@Composable
fun WeekWeatherItem(dayForecast: Forecastday) {
    var expandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.8f),
                        Color.Black
                    ),
                    startY = 1f
                )
            )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.8f)
            ),
            onClick = {
                expandedState = !expandedState
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .background(Color.Transparent),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = dayForecast.date,
                        style = MaterialTheme.typography.bodySmall/*,
                        color = Color.White*/
                    )
                    Image(
                        painter = rememberAsyncImagePainter("https:${dayForecast.day.condition.icon}"),
                        contentDescription = "weather logo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(64.dp)
                    )
                    Text(
                        text = "${dayForecast.day.avgtemp_c}°C",
                        style = MaterialTheme.typography.bodySmall
                    )
                    IconButton(
                        modifier = Modifier
                            .alpha(DefaultAlpha)
                            /*.weight(1f)*/
                            .rotate(rotationState),
                        onClick = {
                            expandedState = !expandedState
                        }
                    ) {
                            Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Drop-down arrow"
                        )
                    }
                }
                if (expandedState) {
                    Text(
                        text = "Wind: ${dayForecast.day.maxwind_kph} km/h",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

        }
    }
}