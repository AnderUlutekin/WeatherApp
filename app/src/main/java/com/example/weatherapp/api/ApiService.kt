package com.example.weatherapp.api

import com.example.weatherapp.model.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "e29366169c325d34b6d8f0995a15ebcd"

interface ApiService {

    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") location: String,
        @Query("appid") key: String = API_KEY,
    ): Call<WeatherData>
}