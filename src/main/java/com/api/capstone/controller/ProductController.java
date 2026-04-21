package com.api.capstone.controller;

import com.api.capstone.model.Product;
import com.api.capstone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
        Product Product = service.createNewProduct(product);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/productos/{id}")
                .buildAndExpand(Product.getId())
                .toUri();

        return ResponseEntity.created(location).body(Product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        return ResponseEntity.ok(service.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
