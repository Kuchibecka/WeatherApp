package com.kuchibecka.weatherapp.screens.mainScreenElements

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuchibecka.weatherapp.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun ExpandableWeatherCard() {
    var expandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier
                        .weight(6f), //TODO: прикрутить везде веса
                    text = "Title",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h6.fontSize
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
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
                    text = "kjaskdjkajskdjkajskdkajsd" +
                            " kjaskdjkajskdjkajskdkajsd" +
                            " kjaskdjkajskdjkajskdkajsd" +
                            " kjaskdjkajskdjkajskdkajsd" +
                            " kjaskdjkajskdjkajskdkajsd" +
                            " kjaskdjkajskdjkajskdkajsd" +
                            " kjaskdjkajskdjkajskdkajsd" +
                            " kjaskdjkajskdjkajskdkajsd",
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Normal,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun ExpandableCardPreview() {
    var expandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .background(Color.Transparent)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
        backgroundColor = Color.Transparent,
        /*
        Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black.copy(alpha = 0.8f),
                                    Color.Black
                                ),
                                startY = 10f
                            )
         */
        onClick = {
            expandedState = !expandedState
        }
    ) {
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
                    Text(text = "dayForecast.date", color = Color.White)
                    /*Image( //TODO: mb replace with Icon()
                        painter = rememberAsyncImagePainter("https:${dayForecast.day.condition.icon}"),
                        contentDescription = "weather logo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(64.dp)
                    )*/
                    Text(
                        text = "dayForecast.day.avgtemp_c °C",
                        color = Color.White.copy(alpha = 0.8f)
                    )
                    IconButton(
                        modifier = Modifier
                            .alpha(ContentAlpha.medium)
                            /*.weight(1f)*/
                            .rotate(rotationState),
                        onClick = {
                            expandedState = !expandedState
                            Log.d("CARD", "expandedState is $expandedState")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Drop-down arrow"
                        )
                    }
                }
                Text(
                    text = "dayForecast.day.maxwind_kph} km/h",
                    color = Color.White.copy(alpha = 0.8f),
                    modifier = Modifier.background(Color.Cyan)
                )
                if (expandedState) {
                    Text(
                        text = "dayForecast.day.maxwind_kph} km/h",
                        color = Color.White.copy(alpha = 0.8f),
                        modifier = Modifier.background(Color.Cyan)
                    )
                }
            }
        }
    }
}