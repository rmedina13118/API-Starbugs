package com.api.capstone.controller;

import com.api.capstone.model.Role;
import com.api.capstone.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(service.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getCategoryById(@PathVariable int id) {
        return ResponseEntity.ok(service.getRoleById(id));
    }

    @PostMapping
    public ResponseEntity<Role> createNewRole(@RequestBody Role role) {
        Role Role = service.createNewRole(role);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/roles/{id}")
                .buildAndExpand(Role.getId())
                .toUri();

        return ResponseEntity.created(location).body(Role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable int id, @RequestBody Role role) {
        return ResponseEntity.ok(service.updateRole(id, role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable int id) {
        service.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
