package com.api.capstone.controller;

import com.api.capstone.model.Bill;
import com.api.capstone.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class BillController {
    @Autowired
    private BillService service;

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(service.getAllBills());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable int id) {
        return ResponseEntity.ok(service.getBillById(id));
    }

    @PostMapping
    public ResponseEntity<Bill> createNewBill(@RequestBody Bill bill) {
        Bill newBill = service.createNewBill(bill);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/facturas/{id}")
                .buildAndExpand(newBill.getId())
                .toUri();

        return ResponseEntity.created(location).body(newBill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable int id, @RequestBody Bill bill) {
        return ResponseEntity.ok(service.updateBill(id, bill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable int id) {
        service.deleteBill(id);
        return ResponseEntity.noContent().build();
    }
}
