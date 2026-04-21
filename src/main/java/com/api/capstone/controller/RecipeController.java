package com.api.capstone.controller;

import com.api.capstone.model.Recipe;
import com.api.capstone.model.Role;
import com.api.capstone.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/recetas")
public class RecipeController {

    @Autowired
    private RecipeService service;

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(service.getAllRecipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable int id) {
        return ResponseEntity.ok(service.getRecipeById(id));
    }

    @PostMapping
    public ResponseEntity<Recipe> createNewRecipe(@RequestBody Recipe recipe) {
        Recipe Recipe = service.createNewRecipe(recipe);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/roles/{id}")
                .buildAndExpand(Recipe.getId())
                .toUri();

        return ResponseEntity.created(location).body(Recipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRole(@PathVariable int id, @RequestBody Recipe role) {
        return ResponseEntity.ok(service.updateRecipe(id, role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable int id) {
        service.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
}
