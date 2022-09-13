package com.springbootforecast.service;

import com.springbootforecast.dto.Weather;

import java.util.List;

public interface WeatherApiService {
    Weather getWeather(String city, String country);
    List<Weather> get_SK_regionalCitiesWeather();
}
