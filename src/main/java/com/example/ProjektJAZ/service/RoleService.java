package com.example.ProjektJAZ.service;

import com.example.ProjektJAZ.model.AppUser;
import com.example.ProjektJAZ.model.Role;
import com.example.ProjektJAZ.model.WorkPc;
import com.example.ProjektJAZ.repository.RoleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleService implements  IDefineRoleService{

    private final RoleRepo roleRepo;

    @Override
    public Role getRole(long id) {
        log.info("Fetching Role with an id {} from the Database", id);
        return roleRepo.findById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        log.info("Fetching Roles from Database");
        return roleRepo.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new Role to the database");
        return roleRepo.save(role);
    }

    @Override
    public void updateRoleName(long id, String name) {
        log.info("Updating Role with an id {}, changing name to {}", id, name);
        Role role = roleRepo.findById(id);
        role.setName(name);
    }
}
