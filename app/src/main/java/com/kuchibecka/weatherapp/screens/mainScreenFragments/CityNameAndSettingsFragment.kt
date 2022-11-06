package com.kuchibecka.weatherapp.screens.mainScreenFragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.kuchibecka.weatherapp.Screen

@Composable
fun CityNameAndSettingsFragment(navController: NavHostController, city: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = city,
            color = Color.White.copy(alpha = 0.8f)
        )
        Button(
            onClick = { navController.navigate(Screen.Settings.route + "/$city") }
        ) {
            Text(
                text = "Settings",
                color = Color.White.copy(alpha = 0.8f)
            )
        }
    }
}