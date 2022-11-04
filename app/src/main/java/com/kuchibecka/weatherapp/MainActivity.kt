package com.kuchibecka.weatherapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kuchibecka.weatherapp.screens.MainScreen
import com.kuchibecka.weatherapp.screens.SettingsScreen
import com.kuchibecka.weatherapp.ui.theme.WeatherAppTheme


const val API_KEY = "93e8bb3d75904109905130630220311"
//TODO: add logs (MUCH logs)
const val MAIN_TAG = "MainActivity"

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*

        val response = try {
            RetrofitInstance.api.getWeekForecast(
                API_KEY,
                "Moscow",
                "7"
            )
        } catch (e: IOException) {
            Log.e(MAIN_TAG, "IOException: mb you don't have internet connection")
        } catch (e: HttpException) {
            Log.e(MAIN_TAG, "HttpException: unexpected response")
        }

        //TODO: check if response is successful
        Log.d(MAIN_TAG, response.toString())
*/

        setContent {
            WeatherAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "mainScreen") {
                    composable("mainScreen") {
                        MainScreen(
                            navController = navController,
                            //TODO: replace with the real today's weather background
                            backgroundImg = R.drawable.logo,
                            //TODO: replace with the real today's weather logo
                            todayWeatherLogo = R.drawable.sun_logo
                        )
                    }
                    composable("settingsScreen") { SettingsScreen(navController = navController) }
                }
            }
        }
    }
}

//TODO: Introduce a new fragment
@Composable
fun WeekWeatherList(weekWeatherForecastData: ArrayList<String>) {
    // Bottom with week weather
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        itemsIndexed(
            weekWeatherForecastData
        ) { _, item ->
            WeekWeatherItem(item)
        }
    }
}

//TODO: maybe introduce a new fragment
@Composable
fun WeekWeatherItem(date: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color.Transparent),
        shape = RoundedCornerShape(9.dp),
        elevation = 3.dp,
        backgroundColor = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.BottomCenter,
        ) {}
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.8f),
                            Color.Black
                        ),
                        startY = 10f
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Row(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(text = date, color = Color.White)
                Image(
                    painter = painterResource(id = R.drawable.sun_logo),
                    contentDescription = "weather logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(64.dp)
                )
                Text(text = "Temperature °C", color = Color.White.copy(alpha = 0.8f))
                Text(text = "Wind speed & direction", color = Color.White.copy(alpha = 0.8f))
            }
        }
    }
    /*}*/
}

//TODO: maybe remove
private fun getWeatherApiData(city: String, state: MutableState<String>, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json" +
            "?key=93e8bb3d75904109905130630220311" +
            "&q=Moscow" +
            "&days=7" +
            "&aqi=no" +
            "&alerts=no"
}