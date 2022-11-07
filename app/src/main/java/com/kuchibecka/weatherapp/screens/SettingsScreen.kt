package com.kuchibecka.weatherapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kuchibecka.weatherapp.MainViewModel
import com.kuchibecka.weatherapp.screens.mainScreenElements.Background

@ExperimentalMaterial3Api
@Composable
//TODO: add BackgroundFragment to remain the same background
fun SettingsScreen(
    navController: NavHostController, viewModel: MainViewModel,
    backgroundImg: Int, cityState: String, searchRequest: String?
) {
    /*cityState*/
    var cityTextField by remember {
        mutableStateOf( searchRequest ?: cityState)
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
        Background(backgroundImg = backgroundImg)
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
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.2f)
                        .background(Color.Transparent),
                    shape = MaterialTheme.shapes.large,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.8f)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Transparent),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Current city is $currentCity",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Button(
                            onClick = {
                                navController.navigate(
                                    Screen.Splash.passCity(currentCity)
                                )
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null
                            )
                            Text(
                                text = "Save & return",
                                style = MaterialTheme.typography.bodySmall
                            )

                        }
                    }
                    // TodayWeatherFragment(todayWeatherLogo)
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = MaterialTheme.shapes.large,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.8f)
                    )
                ) {
                    //TODO: настройки
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Transparent),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.2f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            TextField(
                                value = cityTextField,
                                onValueChange = { cityTextField = it },
                                singleLine = true,
                                colors = TextFieldDefaults.textFieldColors()
                            )
                            Button(onClick = {
                                navController.navigate(
                                    Screen.Splash.passCityAndSearchRequest(
                                        currentCity,
                                        cityTextField
                                    )
                                )
                            }) {
                                Text(
                                    text = "Search",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Icon(imageVector = Icons.Default.Search, contentDescription = null)
                            }
                        }
                        if (searchResult != null) {
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                itemsIndexed(
                                    searchResult.toList()
                                ) { _, location ->
                                    Log.d("SearchRes", "Location name is: ${location.name}")
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .background(Color.Transparent)
                                            .align(Alignment.CenterHorizontally),
                                        shape = MaterialTheme.shapes.large,
                                        colors = CardDefaults.cardColors(
                                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(
                                                alpha = 0.8f
                                            )
                                        )
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentAlignment = Alignment.Center,
                                        ) {
                                            Text(
                                                text = location.country + ", " + location.region + ", " + location.name,
                                                style = MaterialTheme.typography.bodySmall,
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .padding(10.dp)
                                                    .clickable {
                                                        currentCity = location.name
                                                    },
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