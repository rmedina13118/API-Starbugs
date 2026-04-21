package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Role;
import com.api.capstone.repository.RoleRepository;
import com.api.capstone.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleImp implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    @Override
    public Role getRoleById(int id) {
        Role role = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role not found with id: " + id));

        return role;
    }

    @Override
    public Role createNewRole(Role role) {
        return repository.save(role);
    }

    @Override
    public Role updateRole(int id, Role role) {
        Role search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role not found with id: " + id));

        search.setNombre(role.getNombre());
        search.setDescription(role.getDescription());

        return repository.save(search);
    }

    @Override
    public void deleteRole(int id) {
        Role search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role not found with id: " + id));

        repository.delete(search);
    }
}
