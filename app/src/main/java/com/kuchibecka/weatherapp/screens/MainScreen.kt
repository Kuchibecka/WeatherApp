package com.kuchibecka.weatherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kuchibecka.weatherapp.WeekWeatherList
import com.kuchibecka.weatherapp.screens.mainScreenFragments.BackgroundFragment
import com.kuchibecka.weatherapp.screens.mainScreenFragments.CityNameAndSettings
import com.kuchibecka.weatherapp.screens.mainScreenFragments.TodayWeatherFragment

//TODO: check all passed params
@Composable
fun MainScreen(
    navController: NavHostController,
    backgroundImg: Int,
    todayWeatherLogo: Int
) {
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
                        .fillMaxHeight(0.2f)
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
                            CityNameAndSettings(navController = navController)
                            TodayWeatherFragment(todayWeatherLogo = todayWeatherLogo)
                        }
                    }
                }
                //TODO: insert real data list from WeatherAPI
                WeekWeatherList(arrayListOf("1", "2", "3", "4", "5", "6", "7"))
            }
        }
    }
}