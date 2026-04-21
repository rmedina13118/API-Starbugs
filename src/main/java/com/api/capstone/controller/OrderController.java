package com.api.capstone.controller;

import com.api.capstone.model.Order;
import com.api.capstone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(service.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        return ResponseEntity.ok(service.getOrderById(id));
    }

    @PostMapping
    public ResponseEntity<Order> createNewOrder(@RequestBody Order order) {
        Order newOrder = service.createNewOrder(order);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/pedidos/{id}")
                .buildAndExpand(newOrder.getId())
                .toUri();

        return ResponseEntity.created(location).body(newOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order order) {
        return ResponseEntity.ok(service.updateOrder(id, order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
