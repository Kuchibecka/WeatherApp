package com.kuchibecka.weatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val liveDataCurrent = MutableLiveData<String>()
    val liveDataWeekList = MutableLiveData<List<String>>()
}