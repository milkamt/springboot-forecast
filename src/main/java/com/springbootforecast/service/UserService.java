package com.springbootforecast.service;

import com.springbootforecast.dto.UserRegistrationDto;
import com.springbootforecast.model.AppUser;

public interface UserService {
    AppUser registerUser(UserRegistrationDto userRegistrationDto);
}
