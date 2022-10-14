package com.springbootforecast.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootforecast.constant.Cities;
import com.springbootforecast.dto.WeatherDetailDto;
import com.springbootforecast.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class WeatherApiServiceImpl implements WeatherApiService {
    @Value("${api_openweathermap_key}")
    private String API_KEY;
    @Value("${api_openweatherapp_url}")
    private String WEATHER_URL;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public WeatherDto getWeather(String city) {
        URI url = new UriTemplate(WEATHER_URL).expand(city,API_KEY);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return convert(response);
    }

    @Override
    public WeatherDetailDto getWeatherDetail(String city) {
        URI url = new UriTemplate(WEATHER_URL).expand(city,API_KEY);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return convertDetail(response);
    }

    @Override
    public List<WeatherDto> getCentralEuropeCapitals() {
        Cities cities = new Cities();
        List<WeatherDto> weather = new ArrayList<>();
        for (String city : cities.getCentralEuropeCapitals()) {
            weather.add(getWeather(city));
        }
        return weather;
    }

    private WeatherDto convert(ResponseEntity<String> response) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            return new WeatherDto(
                    root.path("name").asText(),
                    root.path("weather").get(0).path("main").asText(),
                    BigDecimal.valueOf(root.path("main").path("temp").asDouble()),
                    BigDecimal.valueOf(root.path("main").path("feels_like").asDouble()));
        } catch (IOException e) {
            throw new RuntimeException("Error parsing JSON", e);

        }
    }

    private WeatherDetailDto convertDetail(ResponseEntity<String> response) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            return new WeatherDetailDto(
                    root.path("name").asText(),
                    root.path("weather").get(0).path("main").asText(),
                    BigDecimal.valueOf(root.path("main").path("temp").asDouble()),
                    BigDecimal.valueOf(root.path("main").path("feels_like").asDouble()),
                    BigDecimal.valueOf(root.path("main").path("temp_min").asDouble()),
                    BigDecimal.valueOf(root.path("main").path("temp_max").asDouble()),
                    BigDecimal.valueOf(root.path("main").path("humidity").asDouble()),
                    BigDecimal.valueOf(root.path("main").path("pressure").asDouble()),
                    BigDecimal.valueOf(root.path("rain").path("1h").asDouble()),
                    BigDecimal.valueOf(root.path("wind").path("speed").asDouble()),
                    formatTime(root.path("sys").path("sunrise").asLong()),
                    formatTime(root.path("sys").path("sunset").asLong()));
        } catch (IOException e) {
            throw new RuntimeException("Error parsing JSON", e);

        }
    }

    private String formatTime(Long unix) {
        LocalDateTime time = LocalDateTime.ofEpochSecond(unix, 0, ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }
}
