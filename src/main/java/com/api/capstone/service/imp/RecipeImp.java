package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Material;
import com.api.capstone.model.Product;
import com.api.capstone.model.Recipe;
import com.api.capstone.repository.MaterialRepository;
import com.api.capstone.repository.ProductRepository;
import com.api.capstone.repository.RecipeRepository;
import com.api.capstone.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeImp implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(int id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Recipe not found with id: " + id));

        return recipe;
    }

    @Override
    public Recipe createNewRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(int id, Recipe recipe) {
        Recipe search = recipeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Recipe not found with id: " + id));
        Material material = materialRepository.findById(recipe.getMaterial().getId())
                .orElseThrow(() -> new NotFoundException("Material not found with id: " + recipe.getMaterial().getId()));
        Product product = productRepository.findById(recipe.getProduct().getId())
                .orElseThrow(() -> new NotFoundException("Material not found with id: " + recipe.getProduct().getId()));

        search.setMaterial(material);
        search.setProduct(product);
        search.setQuantity(recipe.getQuantity());

        return recipeRepository.save(search);
    }

    @Override
    public void deleteRecipe(int id) {
        Recipe search = recipeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Recipe not found with id: " + id));

        recipeRepository.delete(search);
    }
}
