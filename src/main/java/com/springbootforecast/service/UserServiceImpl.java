package com.springbootforecast.service;

import com.springbootforecast.dto.UserRegistrationDto;
import com.springbootforecast.model.AppUser;
import com.springbootforecast.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final AppUserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public AppUser registerUser(UserRegistrationDto userRegistrationDto) {
        AppUser user = new AppUser();
        user.setUsername(userRegistrationDto.getUsername());
        user.setPassword(
                passwordEncoder
                        .encode(userRegistrationDto.getPassword())
        );
        return userRepo.save(user);
    }
}
