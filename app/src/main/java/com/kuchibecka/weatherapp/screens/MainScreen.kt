package com.kuchibecka.weatherapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kuchibecka.weatherapp.MainViewModel
import com.kuchibecka.weatherapp.screens.mainScreenFragments.BackgroundFragment
import com.kuchibecka.weatherapp.screens.mainScreenFragments.CityNameAndSettingsFragment
import com.kuchibecka.weatherapp.screens.mainScreenFragments.TodayWeatherFragment
import com.kuchibecka.weatherapp.screens.mainScreenFragments.WeekWeatherFragment

//TODO: check all passed params
@Composable
fun MainScreen(
    navController: NavHostController, viewModel: MainViewModel,
    backgroundImg: Int, todayWeatherLogo: Int, city: String
) {
    val weekForecast = viewModel.weekForecast.observeAsState().value
    Log.d("Forecast is ", "${weekForecast?.forecast} ${weekForecast?.current} ${weekForecast?.location}")
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BackgroundFragment(backgroundImg = backgroundImg)
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
                    shape = RoundedCornerShape(9.dp),
                    elevation = 3.dp,
                    backgroundColor = Color.Transparent
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
                            weekForecast?.location?.name?.let { CityNameAndSettingsFragment(navController = navController, city = it) }
                            if (weekForecast != null) {
                                TodayWeatherFragment(weekForecast)
                            }
                        }
                    }
                }
                //TODO: insert real data list from WeatherAPI
                weekForecast?.forecast?.let { WeekWeatherFragment(it) }
            }
        }
    }
}