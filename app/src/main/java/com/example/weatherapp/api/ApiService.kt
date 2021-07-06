package com.example.weatherapp.api

import com.example.weatherapp.model.WeatherData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("data/2.5/weather?q=istanbul&appid=e29366169c325d34b6d8f0995a15ebcd")
    suspend fun getWeather(): Response<WeatherData>
}