package com.kuchibecka.weatherapp.dataClasses.search

data class SearchResultItem(
    val country: String,
    val id: Int,
    val lat: Double,
    val lon: Double,
    val name: String,
    val region: String,
    val url: String
)