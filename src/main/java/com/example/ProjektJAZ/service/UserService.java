package com.example.ProjektJAZ.service;

import com.example.ProjektJAZ.model.AppUser;
import com.example.ProjektJAZ.model.Role;
import com.example.ProjektJAZ.repository.RoleRepo;
import com.example.ProjektJAZ.repository.UserRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IDefineUserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user to the database");
        return userRepo.save(user);
    }

    @Override
    public void updateUserRole(long userId, String roleName) {
        log.info("Updating User with an id {} with role {}", userId, roleName);
        AppUser user = userRepo.findUserById(userId);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    @Cacheable(value = "users", key = "#id")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public AppUser getUser(@PathVariable long userId) {
        log.info("Fetching User with an id {} from the Database", userId);
        return userRepo.findUserById(userId);
    }

    @Override

    public List<AppUser> getAllUsers() {
        log.info("Fetching Users from Database");
        return userRepo.findAll();
    }

}
