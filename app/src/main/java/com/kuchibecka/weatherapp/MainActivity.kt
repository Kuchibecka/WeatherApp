package com.kuchibecka.weatherapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.kuchibecka.weatherapp.screens.MainScreen
import com.kuchibecka.weatherapp.ui.theme.WeatherAppTheme
import retrofit2.HttpException
import java.io.IOException


const val API_KEY = "93e8bb3d75904109905130630220311"
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

                MyContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyContent() {
    MainScreen(logo = R.drawable.logo, sun_logo = R.drawable.sun_logo)
}

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
            WeekWeatherItem(item, "")
        }
    }
}


/**
 * Bottom "Weather for the week" element
 *
 * @param weekList list of week dates
 * @param weekLogoIds list of week weather pictures
 *
 */
@Composable
fun WeekWeatherList(weekList: ArrayList<String>, weekLogoIds: ArrayList<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        WeekWeatherItem(weekList[0], weekLogoIds[0])
        WeekWeatherItem(weekList[1], weekLogoIds[1])
        WeekWeatherItem(weekList[2], weekLogoIds[2])
        WeekWeatherItem(weekList[3], weekLogoIds[3])
        WeekWeatherItem(weekList[4], weekLogoIds[4])
        WeekWeatherItem(weekList[5], weekLogoIds[5])
        WeekWeatherItem(weekList[6], weekLogoIds[6])
    }
}

@Composable
fun WeekWeatherItem(date: String, weatherLogoId: String) {
    /*Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {*/
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
                    .background(Color.Transparent) //TODO: ПОЧЕМУ ОН БЕЛЫЙ
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

private fun getWeatherApiData(city: String, state: MutableState<String>, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json" +
            "?key=93e8bb3d75904109905130630220311" +
            "&q=Moscow" +
            "&days=7" +
            "&aqi=no" +
            "&alerts=no"
}