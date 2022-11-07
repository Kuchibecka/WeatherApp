package com.kuchibecka.weatherapp.screens

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.kuchibecka.weatherapp.MainViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: MainViewModel,
    city: String,
    searchRequest: String?
) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
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
        delay(4500)
        if (searchRequest != null) {
            navController.navigate(
                Screen.Settings.passCity(city)
            )
        } else {
            navController.navigate(/*"MainScreen/$city"*/ Screen.Main.passCity(city))
        }
        Log.d("MainScreen", "Launched effect ended")
    }

    SideEffect {
        Log.d("MainScreen", "SIDE EFFECT")
    }
    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Loading...",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}