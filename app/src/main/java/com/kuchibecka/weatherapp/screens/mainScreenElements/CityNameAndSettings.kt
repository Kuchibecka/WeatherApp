package com.kuchibecka.weatherapp.screens.mainScreenElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.kuchibecka.weatherapp.screens.Screen
import com.kuchibecka.weatherapp.ui.theme.Typography

@Composable
fun CityNameAndSettings(navController: NavHostController, city: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f)
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = city,
            style = Typography.titleLarge /*MaterialTheme.typography.bodyLarge*/
        )
        Button(
            onClick = {
                navController.navigate(
                    Screen.Settings.passCity(city)
                )
            }
        ) {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.bodySmall
            )
            Icon(imageVector = Icons.Default.Settings, contentDescription = null)
        }
    }
}