package com.kuchibecka.weatherapp.screens

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kuchibecka.weatherapp.MainViewModel
import com.kuchibecka.weatherapp.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, viewModel: MainViewModel, city: String) {
    Log.d("MainScreen", "City: $city")
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )
    Log.d("MainScreen", "Before launch effect")
    LaunchedEffect(key1 = true) {
        startAnimation = true
        viewModel.getWeekForecast(
            "93e8bb3d75904109905130630220311", //TODO: перенести в отдельный файл константой
            city, "7", "no", "no"
        )
        delay(4000)
        Log.d("MainScreen", "Navigating to ${Screen.Main.route + city}")
        navController.navigate(Screen.Main.route + "/$city")
    }
    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    Log.d("MainScreen", "SPLASH!")
    Log.d("MainScreen", "alpha in Splash(): $alpha")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha),
            imageVector = Icons.Default.DateRange, //TODO: заменить на иконку загрузки
            contentDescription = "",
            tint = Color.Gray
        )
    }
}