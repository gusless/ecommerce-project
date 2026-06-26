package com.lp1.project.domain.product;

import com.lp1.project.domain.repository.ProductRepository;
import com.lp1.project.domain.user.Admin;
import com.lp1.project.domain.user.User;
import com.lp1.project.domain.user.UserRole;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void createProduct(User user, Product product) {
        if (!(user.getRole().equals(UserRole.ADMIN))) {
            throw new RuntimeException("Apenas administradores podem cadastrar produtos.");
        }

        if (repository.findByName(product.getName()) != null) {
            throw new RuntimeException("Produto já existe.");
        }

        repository.save(product);
    }
}
