package com.api.capstone.controller;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Order;
import com.api.capstone.model.Person;
import com.api.capstone.model.enums.OrderState;
import com.api.capstone.repository.OrderRepository;
import com.api.capstone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

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

    @PatchMapping("/{id}/estado")
    public ResponseEntity<?> updateStatus(@PathVariable Integer id, @RequestBody OrderState body) {
        OrderState nuevoEstado = body;

        Order search = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + id));

        orderRepository.updateOrderStatus(search.getId(), nuevoEstado);

        return ResponseEntity.ok("Estado del pedido actualizado correctamente.");
    }

    @PatchMapping("/{id}/preparador")
    public ResponseEntity<?> updatePreparador(@PathVariable Integer id, @RequestBody Person preparador) {
        if (!orderRepository.existsById(id)) {
            throw new NotFoundException("Order not found with id: " + id);
        }

        orderRepository.updateOrderPreparador(id, preparador);
        return ResponseEntity.ok("Preparador asignado correctamente.");
    }


    @PatchMapping("/{id}/entregador")
    public ResponseEntity<?> updateEntregador(@PathVariable Integer id, @RequestBody Person entregador) {
        if (!orderRepository.existsById(id)) {
            throw new NotFoundException("Order not found with id: " + id);
        }

        orderRepository.updateOrderEntregador(id, entregador);
        return ResponseEntity.ok("Entregador asignado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
