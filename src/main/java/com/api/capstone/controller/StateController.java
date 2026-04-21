package com.api.capstone.controller;

import com.api.capstone.model.State;
import com.api.capstone.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class StateController {
    @Autowired
    private StateService service;

    @GetMapping
    public ResponseEntity<List<State>> getAllStates() {
        return ResponseEntity.ok(service.getAllStates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getStateById(@PathVariable int id) {
        return ResponseEntity.ok(service.getStateById(id));
    }

    @PostMapping
    public ResponseEntity<State> createNewState(@RequestBody State state) {
        State State = service.createNewState(state);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/estados/{id}")
                .buildAndExpand(State.getId())
                .toUri();

        return ResponseEntity.created(location).body(State);
    }

    @PutMapping("/{id}")
    public ResponseEntity<State> updateState(@PathVariable int id, @RequestBody State state) {
        return ResponseEntity.ok(service.updateState(id, state));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteState(@PathVariable int id) {
        service.deleteState(id);
        return ResponseEntity.noContent().build();
    }
}
