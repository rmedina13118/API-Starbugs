package com.api.capstone.controller;

import com.api.capstone.model.Person;
import com.api.capstone.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(service.getAllPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
        return ResponseEntity.ok(service.getPersonById(id));
    }

    @PostMapping
    public ResponseEntity<Person> createNewPerson(@RequestBody Person person) {
        Person newPerson = service.createNewPerson(person);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/personas/{id}")
                .buildAndExpand(newPerson.getId())
                .toUri();

        return ResponseEntity.created(location).body(newPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        return ResponseEntity.ok(service.updatePerson(id, person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable int id) {
        service.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}