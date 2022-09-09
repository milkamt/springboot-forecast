package com.springbootforecast.service;

import com.springbootforecast.model.AppUser;
import com.springbootforecast.model.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    AppUser getUser(String userName);
    List<AppUser> getUsers();
}
