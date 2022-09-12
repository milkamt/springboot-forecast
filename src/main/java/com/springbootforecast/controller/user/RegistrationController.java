package com.springbootforecast.controller.user;

import com.springbootforecast.dto.UserRegistrationDto;
import com.springbootforecast.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/user/register/form")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "user/registration";
    }

    @PostMapping("/user/register")
    public String postRegistrationForm(@ModelAttribute("user") UserRegistrationDto user) {
        userService.registerUser(user);
        return "redirect:/login";
    }
}
