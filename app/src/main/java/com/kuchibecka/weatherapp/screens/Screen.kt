package com.kuchibecka.weatherapp.screens

sealed class Screen(val route: String) {
    object Main: Screen(route = "MainScreen/{city}") {
        fun passCity(city: String): String {
            return "MainScreen/$city"
        }
    }
    object Settings: Screen(route = "SettingsScreen/{city}") {
        fun passCity(city: String): String {
            return "SettingsScreen/$city"
        }
    }
    object Splash: Screen(route = "SplashScreen/{city}?searchRequest={searchRequest}"){
        fun passCity(city: String): String {
            return "SplashScreen/$city"
        }

        fun passCityAndSearchRequest(city: String, searchRequest: String): String {
            return "SplashScreen/$city?searchRequest=$searchRequest"
        }
    }
}
