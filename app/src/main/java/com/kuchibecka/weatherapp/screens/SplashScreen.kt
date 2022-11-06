package com.kuchibecka.weatherapp.screens

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
    Log.d("MainScreen", "Splash screen params: City: $city searchRequest: $searchRequest")
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        if (searchRequest != null) {
            Log.d("SettingsSearch", "Searching request: $searchRequest ...")
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
        delay(4000)
        Log.d("MainScreen", "_______________ searchRequest != null: ${searchRequest != null} _______________")
        if (searchRequest != null) {
            Log.d("MainScreen", "Navigating to ${Screen.Settings.passCity(city = city)}")
            navController.navigate(
                Screen.Settings.passCity(city)
            )
        } else {
            Log.d("MainScreen", "Navigating to ${Screen.Main.passCity(city)}")
            navController.navigate(/*"MainScreen/$city"*/ Screen.Main.passCity(city))
        }

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
        Text(text = "Loading...")
    }
}