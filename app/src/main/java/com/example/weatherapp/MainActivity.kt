package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherResponse.observe(this, { weather ->

            if (weather != null) {

                val feelsLike = String.format("%.1f", (weather.main.feelsLike - 273.15)).toDouble()
                val temperature = String.format("%.1f", (weather.main.temp - 273.15)).toDouble()
                val humidity = weather.main.humidity
                val visibility = weather.visibility
                val wind = String.format("%.1f", weather.wind.speed).toDouble()

                binding.apply {

                    tvLocation.text = weather.name
                    tvStatus.text = weather.weather[0].description
                    tvTemperature.text = "$temperature"
                    tvFeelsLike.text = "$feelsLike"
                    tvHumidity.text = "$humidity"
                    tvVisibility.text = "$visibility"
                    tvWind.text = "$wind"
                    if (weather.weather[0].description == "clear sky") {
                        ivWeather.setImageResource(R.drawable.ic_clearsky)
                    }else if (weather.weather[0].description == "few clouds") {
                        ivWeather.setImageResource(R.drawable.ic_fewclouds)
                    }else if (weather.weather[0].description == "scattered clouds") {
                        ivWeather.setImageResource(R.drawable.ic_scatterclouds)
                    }else if (weather.weather[0].description == "broken clouds") {
                        ivWeather.setImageResource(R.drawable.ic_brokenclouds)
                    }else if (weather.weather[0].description == "shower rain") {
                        ivWeather.setImageResource(R.drawable.ic_showerrain)
                    }else if (weather.weather[0].description == "rain") {
                        ivWeather.setImageResource(R.drawable.ic_rain)
                    }else if (weather.weather[0].description == "thunderstorm") {
                        ivWeather.setImageResource(R.drawable.ic_thunderstorm)
                    }else if (weather.weather[0].description == "snow") {
                        ivWeather.setImageResource(R.drawable.ic_snow)
                    }else if (weather.weather[0].description == "mist") {
                        ivWeather.setImageResource(R.drawable.ic_mist)
                    }
                }

            }
        })

    }
}