package com.example.ProjektJAZ.service;

import com.example.ProjektJAZ.model.AppUser;
import com.example.ProjektJAZ.model.Role;

import java.util.List;

public interface IDefineUserService {
    AppUser saveUser(AppUser user);

    void updateUserRole(long userId, String roleName);


    AppUser getUser(long userId);
    List<AppUser> getAllUsers();
}
