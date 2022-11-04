package com.kuchibecka.weatherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
//TODO: add BackgroundFragment to remain the same background
fun SettingsScreen(navController: NavHostController) {
    Button(onClick = { navController.navigate("mainScreen") }) {
        Text(text = "GO BACK", modifier = Modifier.padding(50.dp))
    }
}

//TODO: make almost the same layout as on the main screen
@Preview
@Composable
fun SettingsScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Black.copy(alpha = 0.8f))
                .fillMaxSize(0.1f)
        ) {
            Button(onClick = { }) {
                Text(text = "GO BACK"/*, modifier = Modifier.padding(10.dp)*/)
            }
        }
        Box(
            modifier = Modifier
                .background(Color.Black.copy(alpha = 0.8f))
                .fillMaxSize()
        ) {
            Button(onClick = { }) {
                Text(text = "CONTENT", modifier = Modifier.padding(10.dp))
            }
        }
    }


}