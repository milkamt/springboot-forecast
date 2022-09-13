package com.springbootforecast.controller;

import com.springbootforecast.service.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final WeatherApiService weatherApiService;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("weather", weatherApiService.get_SK_regionalCitiesWeather());
        return "index";
    }
}
