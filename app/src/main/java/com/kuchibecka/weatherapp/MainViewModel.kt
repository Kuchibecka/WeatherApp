package com.kuchibecka.weatherapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuchibecka.weatherapp.dataClasses.forecast.ForecastData
import com.kuchibecka.weatherapp.dataClasses.search.SearchResult
import com.kuchibecka.weatherapp.dataClasses.search.SearchResultItem
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
            Log.d("MainScreen", "Processing request")
            repository.getForecast(key, city, days, aqi, alerts).let { response ->
                if (response.isSuccessful) {
                    _weekForecast.postValue(response.body() as ForecastData)
                } else {
                    Log.d("network", "getForecast(): Failed to load forecast: ${response.errorBody()}")
                }
                Log.d("MainScreen", "Inside of response ->")
            }
            Log.d("MainScreen", "End of viewModelScope")
        }
        Log.d("MainScreen", "Out of viewModelScope")
    }

    private val _searchAutocomplete = MutableLiveData<ArrayList<SearchResultItem>>()
    val searchAutocomplete: LiveData<ArrayList<SearchResultItem>>
    get() = _searchAutocomplete

    fun getSearchAutocomplete(key: String, searchRequest: String) {
        viewModelScope.launch {
            repository.getSearch(key, searchRequest).let { response ->
                if (response.isSuccessful) {
                    _searchAutocomplete.postValue(response.body() as ArrayList<SearchResultItem>)
                } else {
                    Log.d("network", "getSearchAutocomplete(): Failed to searchAutocomplete: ${response.errorBody()}")
                }
            }
        }
    }
}