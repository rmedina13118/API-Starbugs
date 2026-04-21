package com.api.capstone.service;

import com.api.capstone.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    Category createNewCategory(Category category);
    Category updateCategory(int id, Category category);
    void deleteCategory(int id);
}
