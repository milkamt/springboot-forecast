package com.springbootforecast.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDetailDto {
    private String city;
    private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private BigDecimal temp_min;
    private BigDecimal temp_max;
    private BigDecimal humidity;
    private BigDecimal pressure;
    private BigDecimal rain;
    private BigDecimal windSpeed;
    private String sunrise;
    private String sunset;

    @Override
    public String toString() {
        return "WeatherDetailDto{" +
                "city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", temperature=" + temperature +
                ", feelsLike=" + feelsLike +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", rain=" + rain +
                ", windSpeed=" + windSpeed +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
