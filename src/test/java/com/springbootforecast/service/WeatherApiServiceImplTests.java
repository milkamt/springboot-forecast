package com.springbootforecast.service;

import com.springbootforecast.dto.Weather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class WeatherApiServiceImplTests {

    @Autowired
    private WeatherApiService weatherApiService;

    @Test
    public void getWeatherOK() {
        Weather weather = weatherApiService.getWeather("Bratislava");

        assertThat(weather).isNotNull();
    }

    @Test
    public void getCentralEuropeCapitalsOK() {
        List<Weather> weathers = weatherApiService.getCentralEuropeCapitals();

        assertEquals(weathers.size(), 5);
    }

}
