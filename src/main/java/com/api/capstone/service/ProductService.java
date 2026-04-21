package com.api.capstone.service;

import com.api.capstone.model.Product;


import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProductById(int id);
    Product createNewProduct(Product product);
    Product updateProduct(int id, Product product);
    void deleteProduct(int id);
}
