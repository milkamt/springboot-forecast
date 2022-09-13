package com.springbootforecast.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Weather implements Serializable {
    private String city;
    private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", temperature=" + temperature +
                ", feelsLike=" + feelsLike +
                '}';
    }
}
