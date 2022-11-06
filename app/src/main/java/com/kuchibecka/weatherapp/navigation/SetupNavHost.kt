package com.kuchibecka.weatherapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kuchibecka.weatherapp.MainViewModel
import com.kuchibecka.weatherapp.R
import com.kuchibecka.weatherapp.Screen
import com.kuchibecka.weatherapp.screens.MainScreen
import com.kuchibecka.weatherapp.screens.SettingsScreen
import com.kuchibecka.weatherapp.screens.SplashScreen

@Composable
fun SetupNavHost(
    navController: NavHostController, viewModel: MainViewModel,
    initialCity: String, backgroundImg: Int
) {
    Log.d("MainScreen", "SetupNavHost")
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route + "/{city}" //TODO: заменить на SplashScreen
    ) {
        composable(
            route = Screen.Splash.route + "/{city}",
            arguments = listOf(
                navArgument("city") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = initialCity //TODO: заменить
                }
            )
        ) {
            Log.d("MainScreen", "Before SplashScreen() arg is: ${it.arguments?.getString("city") ?: "suka"}")
            SplashScreen(
                navController = navController,
                viewModel = viewModel,
                city = it.arguments?.getString("city")
                    ?: initialCity
            )
        }
        composable(
            route = Screen.Main.route + "/{city}",
            arguments = listOf(
                navArgument("city") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = initialCity //TODO: заменить
                }
            )
        ) {
            Log.d("MainScreen", "Argument is ${it.arguments?.getString("city")}")
            MainScreen(
                navController = navController,
                viewModel = viewModel,
                //TODO: replace with the real today's weather background
                backgroundImg = backgroundImg,
                //TODO: replace with the real today's weather logo
                todayWeatherLogo = R.drawable.sun_logo,
                city = it.arguments?.getString("city")
                    ?: initialCity //TODO: заменить на рил навзание города из местоположения
            )
        }
        composable(
            route = Screen.Settings.route + "/{city}",
            arguments = listOf(
                navArgument("city") {
                    type = NavType.StringType
                    defaultValue = initialCity
                })
        ) {
            SettingsScreen(
                navController = navController,
                viewModel = viewModel,
                backgroundImg = backgroundImg,
                todayWeatherLogo = R.drawable.sun_logo,
                cityState = it.arguments?.getString("city") ?: initialCity
            )
        }
    }
}