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

@Composable
fun CityNameAndSettings(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Current city name",
            color = Color.White.copy(alpha = 0.8f)
        )
        Button(
            onClick = { navController.navigate("settingsScreen") }
        ) {
            Text(
                text = "GO TO SETTINGS",
                color = Color.White.copy(alpha = 0.8f)
            )
        }
    }
}