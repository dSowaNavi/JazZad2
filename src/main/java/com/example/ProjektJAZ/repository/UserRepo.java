package com.example.ProjektJAZ.repository;

import com.example.ProjektJAZ.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findUserById(long id);

}
