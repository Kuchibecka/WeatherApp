package com.kuchibecka.weatherapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuchibecka.weatherapp.dataClasses.*
import com.kuchibecka.weatherapp.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {
    private val _weekForecast = MutableLiveData<ForecastData>()
    val weekForecast: LiveData<ForecastData>
    get() = _weekForecast

    fun getWeekForecast(key: String, city: String, days: String = "7", aqi: String = "no", alerts: String = "no") {
        viewModelScope.launch {
            repository.getForecast(key, city, days, aqi, alerts).let { response ->
                if (response.isSuccessful) {
                    _weekForecast.postValue(response.body() as ForecastData)
                } else {
                    Log.d("getForecast", "Failed to load forecast: ${response.errorBody()}")
                }
            }
        }
    }
}