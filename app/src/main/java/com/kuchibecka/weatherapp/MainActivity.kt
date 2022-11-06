package com.kuchibecka.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.kuchibecka.weatherapp.navigation.SetupNavHost
import com.kuchibecka.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint


//TODO: add logs (MUCH logs)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO: заменить isDarkModeEnabled на системную настройку, добавить такую настройку в экран SettingsScreen
        //TODO: заменить на полученное из местоположения
        val initialCity = "Moscow"

        //TODO: заменить на реальную
        val backgroundImg: Int = R.drawable.logo

        Log.d("MainScreen", "MainActivity")

        setContent {
            WeatherAppTheme {
                val navController = rememberNavController()
                val viewModel = hiltViewModel<MainViewModel>()
                SetupNavHost(
                    navController = navController,
                    viewModel = viewModel,
                    initialCity = initialCity,
                    backgroundImg = backgroundImg
                )
            }
        }
    }
}