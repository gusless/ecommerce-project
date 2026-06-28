package com.lp1.project.domain.repository;

import com.google.gson.reflect.TypeToken;
import com.lp1.project.domain.category.Category;
import com.lp1.project.domain.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends JsonRepository<Product> {

   private static final String FILE_PATH = "data/products.json";

   public ProductRepository() {
       super(FILE_PATH, new TypeToken<List<Product>>(){}.getType());
       Product.synchronizeIdCounter(findAll());
   }

    public Product findById(long id) {
        return items.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Product findByName(String name) {
       return items.stream()
               .filter(p -> p.getName().equalsIgnoreCase(name))
               .findAny()
               .orElse(null);
    }

    public List<Product> findProductsInStock(){
        return items.stream()
                .filter(p -> p.getStockQuantity() > 0)
                .toList();
    }

    public List<Product> findByPriceGreaterOrEqualThan(double price){
        return findProductsInStock().stream()
                .filter(p -> p.getPrice().compareTo(BigDecimal.valueOf(price)) >= 0)
                .toList();
    }

    public List<Product> findByPriceLessOrEqualThan(double price){
        return findProductsInStock().stream()
                .filter(p -> p.getPrice().compareTo(BigDecimal.valueOf(price)) <= 0)
                .toList();
    }

    public List<Product> findByPriceMinAndMax(double priceMin, double priceMax){
        return findProductsInStock().stream()
                .filter(p -> p.getPrice().compareTo(BigDecimal.valueOf(priceMin)) >= 0 &&
                                p.getPrice().compareTo(BigDecimal.valueOf(priceMax)) <= 0)
                .toList();
    }

    public List<Product> findByCategory(Category category){
        return findProductsInStock().stream()
                .filter(p -> verifyCategory(p, category))
                .toList();
    }

    public List<Product> findByAtLeastOneReview() {
        return items.stream()
                .filter(p -> p.getReviews() != null && !p.getReviews().isEmpty())
                .toList();
    }

    private boolean verifyCategory(Product product, Category category){
        Category current = product.getCategory();
        while (current != null){
            if (current.equals(category)){
                return true;
            }
            current = current.getParentCategory();
        }
        return false;
    }

}
