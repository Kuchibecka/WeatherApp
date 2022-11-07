package com.kuchibecka.weatherapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kuchibecka.weatherapp.MainViewModel
import com.kuchibecka.weatherapp.screens.mainScreenElements.Background
import com.kuchibecka.weatherapp.screens.mainScreenElements.CityNameAndSettings
import com.kuchibecka.weatherapp.screens.mainScreenElements.TodayWeather
import com.kuchibecka.weatherapp.screens.mainScreenElements.WeekWeather

//TODO: check all passed params
@Composable
@ExperimentalMaterial3Api
fun MainScreen(
    navController: NavHostController, viewModel: MainViewModel,
    backgroundImg: Int, todayWeatherLogo: Int, city: String
) {
    val weekForecast = viewModel.weekForecast.observeAsState().value
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Background(backgroundImg = backgroundImg)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            Column( //TODO: replace with LazyColumn
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxSize()
                    .padding(3.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f)
                        .background(Color.Transparent),
                    shape = MaterialTheme.shapes.large,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.8f)
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Black.copy(alpha = 0.8f))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            weekForecast?.location?.name?.let { CityNameAndSettings(navController = navController, city = city) }
                            if (weekForecast != null) {
                                TodayWeather(weekForecast)
                            }
                        }
                    }
                }
                //TODO: insert real data list from WeatherAPI
                weekForecast?.forecast?.let { WeekWeather(it) }
            }
        }
    }
}