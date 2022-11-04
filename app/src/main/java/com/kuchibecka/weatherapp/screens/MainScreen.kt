package com.kuchibecka.weatherapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kuchibecka.weatherapp.WeekWeatherList

//TODO: привести в порядок структуру проекта, разнести компоненты в отдельные файлы

@Composable
fun MainScreen(logo: Int, sun_logo: Int) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = logo) /*TODO: painterResource(id = R.drawable.logo)*/,
                contentDescription = "Main background",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            Column( //TODO: заменить на LazyColumn
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
                                    onClick = { /*TODO*/ }
                                ) {
                                    Text(text = "Settings", color = Color.White.copy(alpha = 0.8f))
                                }
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.7f)
                                    .background(Color.Transparent),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = sun_logo),
                                    contentDescription = "weather logo",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(64.dp)
                                        .clip(CircleShape)
                                )
                                Text(
                                    text = "Detailed today's weather info",
                                    color = Color.White.copy(alpha = 0.8f)
                                )
                            }
                        }
                    }
                }

                WeekWeatherList(arrayListOf("1", "2", "3", "4", "5", "6", "7"))
            }
        }
    }
}