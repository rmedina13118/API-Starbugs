package com.api.capstone.controller;

import com.api.capstone.model.SupplierMaterial;
import com.api.capstone.service.SupplierMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/insumos-materiales")
public class SupplierMaterialController {
    @Autowired
    private SupplierMaterialService service;

    @GetMapping
    public ResponseEntity<List<SupplierMaterial>> getAllSupplierMaterial() {
        return ResponseEntity.ok(service.getAllSupplierMaterial());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierMaterial> getSupplierMaterialById(@PathVariable int id) {
        return ResponseEntity.ok(service.getSupplierMaterialById(id));
    }

    @PostMapping
    public ResponseEntity<SupplierMaterial> createNewSupplierMaterial(@RequestBody SupplierMaterial supplierMaterial) {
        SupplierMaterial newSupplierMaterial = service.createNewSupplierMaterial(supplierMaterial);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/insumos-materiales/{id}")
                .buildAndExpand(newSupplierMaterial.getId())
                .toUri();

        return ResponseEntity.created(location).body(newSupplierMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierMaterial> updateSupplierMaterial(@PathVariable int id, @RequestBody SupplierMaterial supplierMaterial) {
        return ResponseEntity.ok(service.updateSupplierMaterial(id, supplierMaterial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplierMaterial(@PathVariable int id) {
        service.deleteSupplierMaterial(id);
        return ResponseEntity.noContent().build();
    }
}