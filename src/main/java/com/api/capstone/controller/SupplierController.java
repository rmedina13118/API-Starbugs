package com.api.capstone.controller;

import com.api.capstone.model.Supplier;
import com.api.capstone.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class SupplierController {
    @Autowired
    private SupplierService service;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(service.getAllSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int id) {
        return ResponseEntity.ok(service.getSupplierById(id));
    }

    @PostMapping
    public ResponseEntity<Supplier> createNewSupplier(@RequestBody Supplier supplier) {
        Supplier newSupplier = service.createNewSupplier(supplier);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/proveedores/{id}")
                .buildAndExpand(newSupplier.getId())
                .toUri();

        return ResponseEntity.created(location).body(newSupplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) {
        return ResponseEntity.ok(service.updateSupplier(id, supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int id) {
        service.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}