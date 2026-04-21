package com.api.capstone.service;

import com.api.capstone.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(int id);
    Recipe createNewRecipe(Recipe recipe);
    Recipe updateRecipe(int id, Recipe recipe);
    void deleteRecipe(int id);
}
