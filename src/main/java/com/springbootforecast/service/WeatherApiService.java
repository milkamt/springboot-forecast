package com.springbootforecast.service;

import com.springbootforecast.dto.Weather;

import java.util.List;

public interface WeatherApiService {
    Weather getWeather(String city);
    List<Weather> getCentralEuropeCapitals();
}
