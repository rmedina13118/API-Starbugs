package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Category;
import com.api.capstone.model.Product;
import com.api.capstone.repository.CategoryRepository;
import com.api.capstone.repository.ProductRepository;
import com.api.capstone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));

        return product;
    }

    @Override
    public Product createNewProduct(Product product) {
        Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + product.getCategory().getId()));

        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + product.getCategory().getId()));
        Product search = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));

        search.setCategory(category);
        search.setName(product.getName());
        search.setDescription(product.getDescription());
        search.setPrice(product.getPrice());
        search.setAvailability(product.getAvailability());

        return productRepository.save(search);
    }

    @Override
    public void deleteProduct(int id) {
        Product search = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));

        productRepository.delete(search);
    }
}
