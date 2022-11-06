package com.kuchibecka.weatherapp

sealed class Screen(val route: String) {
    object Main: Screen(route = "MainScreen/{city}")
    object Settings: Screen(route = "SettingsScreen/{city}")
    object Splash: Screen(route = "SplashScreen/{city}")
}
