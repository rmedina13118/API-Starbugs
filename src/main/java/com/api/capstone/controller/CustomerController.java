package com.api.capstone.controller;

import com.api.capstone.model.Customer;
import com.api.capstone.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customer) {
        Customer Customer = service.createNewCustomer(customer);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/clientes/{id}")
                .buildAndExpand(Customer.getId())
                .toUri();

        return ResponseEntity.created(location).body(Customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        return ResponseEntity.ok(service.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
