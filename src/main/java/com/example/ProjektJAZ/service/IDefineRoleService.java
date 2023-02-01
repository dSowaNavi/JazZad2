package com.example.ProjektJAZ.service;

import com.example.ProjektJAZ.model.Role;

import java.util.List;

public interface IDefineRoleService {

    Role getRole(long id);
    List<Role> getAllRoles();
    Role saveRole(Role role);
    void updateRoleName(long id, String name);

}
