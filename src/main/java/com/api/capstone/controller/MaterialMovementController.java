package com.api.capstone.controller;

import com.api.capstone.model.MaterialMovement;
import com.api.capstone.service.MaterialMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MaterialMovementController {
    @Autowired
    private MaterialMovementService service;

    @GetMapping
    public ResponseEntity<List<MaterialMovement>> getAllMaterialMovement() {
        return ResponseEntity.ok(service.getAllMaterialMovement());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialMovement> getMaterialMovementById(@PathVariable int id) {
        return ResponseEntity.ok(service.getMaterialMovementById(id));
    }

    @PostMapping
    public ResponseEntity<MaterialMovement> createNewMaterialMovement(@RequestBody MaterialMovement materialMovement) {
        MaterialMovement newMovement = service.createNewMaterialMovement(materialMovement);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/movimientos/{id}")
                .buildAndExpand(newMovement.getId())
                .toUri();

        return ResponseEntity.created(location).body(newMovement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialMovement> updateMaterialMovement(@PathVariable int id, @RequestBody MaterialMovement materialMovement) {
        return ResponseEntity.ok(service.updateMaterialMovement(id, materialMovement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterialMovement(@PathVariable int id) {
        service.deleteMaterialMovement(id);
        return ResponseEntity.noContent().build();
    }
}
