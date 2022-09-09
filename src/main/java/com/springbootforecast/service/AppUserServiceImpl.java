package com.springbootforecast.service;

import com.springbootforecast.model.AppUser;
import com.springbootforecast.model.Role;
import com.springbootforecast.repository.AppUserRepository;
import com.springbootforecast.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AppUserServiceImpl implements AppUserService{

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getUsername());

        return appUserRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());

        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppUser user = appUserRepository.findAppUserByUsername(userName);
        Role role = roleRepository.findByName(roleName);

        log.info("Assigning role {} to the user {}", roleName, userName);

        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String userName) {
        log.info("Fetching user {}", userName);

        return appUserRepository.findAppUserByUsername(userName);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");

        return appUserRepository.findAll();
    }
}
