package com.example.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.repository.WeatherRepository
import com.example.weatherapp.model.WeatherData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel
@Inject
constructor(private val repository: WeatherRepository, private val location: String = "istanbul") : ViewModel() {

    private val _response = MutableLiveData<WeatherData>()
    val weatherResponse: LiveData<WeatherData>
        get() = _response

    init {
        getWeather(location)
    }

    fun getWeather(location: String) = viewModelScope.launch {
        repository.getWeather(location)
    }

}