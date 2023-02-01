package com.example.ProjektJAZ.repository;


import com.example.ProjektJAZ.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
    Role findById(long id);
}
