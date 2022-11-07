package com.kuchibecka.weatherapp.screens

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.kuchibecka.weatherapp.MainViewModel

@Composable
fun LoadingScreen(
    navController: NavController,
    viewModel: MainViewModel,
    city: String,
    searchRequest: String?
) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 360f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        Log.d("MainScreen", "Launched effect started")
        if (searchRequest != null) {
            viewModel.getSearchAutocomplete(
                "93e8bb3d75904109905130630220311",
                searchRequest
            )
        } else {
            viewModel.getWeekForecast(
                "93e8bb3d75904109905130630220311", //TODO: перенести в отдельный файл константой
                city, "7", "no", "no"
            )
        }
        if (searchRequest != null) {
            navController.navigate(
                Screen.Settings.passCityAndSearchRequest(
                    city = city,
                    searchRequest = searchRequest
                )
            )
        } else {
            navController.navigate(Screen.Main.passCity(city))
        }
    }
    Loading(alphaAnimation.value)
}

@Composable
fun Loading(angle: Float) {
    Log.d("Rotation", "angle: $angle")
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Loading... ",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White.copy(0.8f)
        )
        Icon(
            imageVector = Icons.Default.Clear,
            tint = Color.White.copy(0.8f),
            contentDescription = null,
            modifier = Modifier
                .rotate(angle * 10)
        )
    }
}