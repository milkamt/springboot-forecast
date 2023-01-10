package com.springbootforecast.controller;
import com.springbootforecast.service.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                             RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("searchResult", weatherApiService.getWeather(city));
        return "redirect:/";
    }

    @GetMapping("/detail/{city}")
    public String getDetail(@PathVariable String city, Model model) {
        model.addAttribute("detail", weatherApiService.getWeatherDetail(city));
        return "weatherDetail";
    }
}
