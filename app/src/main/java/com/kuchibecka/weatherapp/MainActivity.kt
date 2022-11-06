package com.kuchibecka.weatherapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.MutableState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kuchibecka.weatherapp.navigation.SetupNavHost
import com.kuchibecka.weatherapp.screens.MainScreen
import com.kuchibecka.weatherapp.screens.SettingsScreen
import com.kuchibecka.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint


//TODO: add logs (MUCH logs)
const val MAIN_TAG = "MainActivity"

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

//TODO: Introduce a new fragment


//TODO: maybe introduce a new fragment


//TODO: remove
private fun getWeatherApiData(city: String, state: MutableState<String>, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json" +
            "?key=93e8bb3d75904109905130630220311" +
            "&q=Moscow" +
            "&days=7" +
            "&aqi=no" +
            "&alerts=no"
}