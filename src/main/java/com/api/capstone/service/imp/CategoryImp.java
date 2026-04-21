package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Category;
import com.api.capstone.repository.CategoryRepository;
import com.api.capstone.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImp implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found with id: " + id));

        return category;
    }

    @Override
    public Category createNewCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Category updateCategory(int id, Category category) {
        Category search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found with id: " + id));

        search.setName(category.getName());
        search.setDescription(category.getDescription());

        return repository.save(search);
    }

    @Override
    public void deleteCategory(int id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found with id: " + id));

        repository.delete(category);
    }
}
