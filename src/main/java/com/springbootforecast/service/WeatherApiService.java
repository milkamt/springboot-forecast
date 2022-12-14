package com.springbootforecast.service;

import com.springbootforecast.dto.WeatherDetailDto;
import com.springbootforecast.dto.WeatherDto;

import java.util.List;

public interface WeatherApiService {
    WeatherDto getWeather(String city);
    List<WeatherDto> getCentralEuropeCapitals();
    WeatherDetailDto getWeatherDetail(String city);
}
