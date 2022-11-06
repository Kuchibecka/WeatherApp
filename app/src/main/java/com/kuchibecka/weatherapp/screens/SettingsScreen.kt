package com.kuchibecka.weatherapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kuchibecka.weatherapp.MainViewModel
import com.kuchibecka.weatherapp.Screen
import com.kuchibecka.weatherapp.screens.mainScreenFragments.BackgroundFragment
import com.kuchibecka.weatherapp.screens.mainScreenFragments.TodayWeatherFragment

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
                                    onClick = { navController.navigate(Screen.Main.route + "/$currentCity") }
                                ) {
                                    Text(
                                        text = "BACK",
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
                            Row {
                                //TODO: добавить snackbar
                                //TODO: заменить на MaterialUI TextField() с label "Enter your city name"
                                TextField(
                                    value = cityTextField,
                                    onValueChange = { cityTextField = it },
                                    singleLine = true/*,
                                    modifier = Modifier.fillMaxWidth()*/
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Button(onClick = {
                                    /*snackbarHostState.showSnackbar("City changed to $cityTextField")*/
                                    if (true /* TODO: Отправить запрос, если не словили оишбку, обновляем поле, словили -- выводим сообщение об ошибке */) {
                                        currentCity = cityTextField
                                    } else {
                                        //TODO: вывести сообщение об ошибке
                                    }
                                }) {
                                    Text("Save")
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}