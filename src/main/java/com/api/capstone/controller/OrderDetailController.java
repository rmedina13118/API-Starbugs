package com.api.capstone.controller;

import com.api.capstone.model.OrderDetail;
import com.api.capstone.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class OrderDetailController {

    @Autowired
    private OrderDetailService service;

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        return ResponseEntity.ok(service.getAllOrderDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable int id) {
        return ResponseEntity.ok(service.getOrderDetailById(id));
    }

    @PostMapping
    public ResponseEntity<OrderDetail> createNewOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail detail = service.createNewOrderDetail(orderDetail);

        // Genera la URI siguiendo el estándar que usaste en RoleController
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/order-details/{id}")
                .buildAndExpand(detail.getId())
                .toUri();

        return ResponseEntity.created(location).body(detail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable int id, @RequestBody OrderDetail orderDetail) {
        return ResponseEntity.ok(service.updateOrderDetail(id, orderDetail));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable int id) {
        service.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}