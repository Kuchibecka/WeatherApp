package com.kuchibecka.weatherapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kuchibecka.weatherapp.MainViewModel
import com.kuchibecka.weatherapp.screens.mainScreenFragments.BackgroundFragment

@Composable
//TODO: add BackgroundFragment to remain the same background
fun SettingsScreen(
    navController: NavHostController, viewModel: MainViewModel,
    backgroundImg: Int, todayWeatherLogo: Int, cityState: String
) {
    /*cityState*/
    var cityTextField by remember {
        mutableStateOf(cityState)
    }
    var currentCity by remember {
        mutableStateOf(cityState)
    }

    val searchResult = viewModel.searchAutocomplete.observeAsState().value

    Log.d("SettingsSearch", "Search result is $searchResult")

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        //TODO: вернуть
        BackgroundFragment(backgroundImg = backgroundImg)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            Column(
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
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Transparent),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = currentCity,
                                    color = Color.White.copy(alpha = 0.8f)
                                )
                                Button(
                                    onClick = {
                                        navController.navigate(
                                            Screen.Splash.passCity(currentCity)
                                        )
                                    }
                                ) {
                                    Text(
                                        text = "Back",
                                        color = Color.White.copy(alpha = 0.8f)
                                    )
                                }
                            }
                            // TodayWeatherFragment(todayWeatherLogo)
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(9.dp),
                    elevation = 3.dp,
                    backgroundColor = Color.Transparent
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Black.copy(alpha = 0.8f))
                    ) {
                        //TODO: здесь будут настройки
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Transparent),
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                            /*.border(width = 1.dp, color = Color.White.copy(alpha = 0.8f))*/
                            /*TODO: везде добавить .blur()*/
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.2f)
                            ) {
                                //TODO: добавить snackbar
                                //TODO: заменить на MaterialUI TextField() с label "Enter your city name"
                                TextField(
                                    value = cityTextField,
                                    onValueChange = { cityTextField = it },
                                    singleLine = true
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Button(onClick = {
                                    /*snackbarHostState.showSnackbar("City changed to $cityTextField")*/
                                    Log.d(
                                        "SettingsSearch",
                                        "Navigating to ${
                                            Screen.Splash.passCityAndSearchRequest(
                                                currentCity,
                                                cityTextField
                                            )
                                        }"
                                    )
                                    navController.navigate(
                                        Screen.Splash.passCityAndSearchRequest(
                                            currentCity,
                                            cityTextField
                                        )
                                    )
                                }) {
                                    Text("Search")
                                }
                            }
                            if (searchResult != null) {
                                LazyColumn(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight()
                                ) {
                                    itemsIndexed(
                                        searchResult.toList()
                                    ) { _, location ->
                                        Log.d("SearchRes", "Location name is: ${location.name}")
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(60.dp)
                                                .background(Color.Transparent),
                                            shape = RoundedCornerShape(9.dp),
                                            elevation = 3.dp,
                                            backgroundColor = Color.Transparent
                                        ) {
                                            Text(
                                                text = location.country + ", " + location.region + ", " + location.name,
                                                modifier = Modifier.fillMaxWidth().clickable {
                                                    currentCity = location.name
                                                }
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}