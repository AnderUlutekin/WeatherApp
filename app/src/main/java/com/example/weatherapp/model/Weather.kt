package com.example.weatherapp.model


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description")
    val description: String
)