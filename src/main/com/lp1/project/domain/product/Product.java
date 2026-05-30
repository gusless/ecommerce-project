package com.lp1.project.domain.product;

import com.lp1.project.domain.brand.Brand;
import com.lp1.project.domain.category.Category;
import com.lp1.project.domain.review.Review;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private long id;
    private String productName;
    private String description;
    private Integer stockQuantity;
    private BigDecimal price;
    private Brand brand;
    private Category category;
    private Float weight;
    private String technicalSpecs;
    private Float totalRating;
    private List<Review> reviews;
    private Integer warrantyMonths;

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public Category getCategory() {
        return category;
    }

    public Float getWeight() {
        return weight;
    }

    public String getTechnicalSpecs() {
        return technicalSpecs;
    }

    public Float getTotalRating() {
        return totalRating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Integer getWarrantyMonths() {
        return warrantyMonths;
    }
}
