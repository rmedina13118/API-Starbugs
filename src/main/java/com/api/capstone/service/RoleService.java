package com.api.capstone.service;

import com.api.capstone.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(int id);
    Role createNewRole(Role role);
    Role updateRole(int id, Role role);
    void deleteRole(int id);
}
