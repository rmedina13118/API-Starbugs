package com.api.capstone.controller;

import com.api.capstone.model.Material;
import com.api.capstone.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/insumos")
public class MaterialController {
    @Autowired
    private MaterialService service;

    @GetMapping
    public ResponseEntity<List<Material>> getAllMaterial() {
        return ResponseEntity.ok(service.getAllMaterial());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMateriaById(@PathVariable int id) {
        return ResponseEntity.ok(service.getMaterialById(id));
    }

    @PostMapping
    public ResponseEntity<Material> createNewMaterial(@RequestBody Material material) {
        Material Material = service.createNewMaterial(material);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/insumos/{id}")
                .buildAndExpand(Material.getId())
                .toUri();

        return ResponseEntity.created(location).body(Material);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable int id, @RequestBody Material material) {
        return ResponseEntity.ok(service.updateMaterial(id, material));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable int id) {
        service.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}
