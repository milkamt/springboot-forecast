package com.springbootforecast.controller;
import com.springbootforecast.service.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherApiService weatherApiService;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("weather", weatherApiService.getCentralEuropeCapitals());
        return "index";
    }

    @PostMapping("/search")
    public String searchCity(@RequestParam String city,
                             Model model) {
        model.addAttribute("weather", weatherApiService.getWeather(city));
        return "index";
    }
}
