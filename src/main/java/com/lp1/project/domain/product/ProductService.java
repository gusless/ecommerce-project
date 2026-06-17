package com.lp1.project.domain.product;

import com.lp1.project.domain.repository.ProductRepository;
import com.lp1.project.domain.user.Admin;
import com.lp1.project.domain.user.User;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void createProduct(User user, Product product) {
        if (!(user instanceof Admin)) {
            throw new RuntimeException("Apenas administradores podem cadastrar produtos.");
        }

        if (repository.findByName(product.getName()) != null) {
            throw new RuntimeException("Produto já existe.");
        }

        
    }
}
