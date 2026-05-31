package com.lp1.project.domain.product;

import com.lp1.project.domain.brand.Brand;
import com.lp1.project.domain.category.Category;
import com.lp1.project.domain.review.Review;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private long id;
    private String name;
    private String description;
    private Integer stockQuantity;
    private BigDecimal price;
    private Brand brand;
    private Category category;
    private Float weight;
    private String technicalSpecs;
    private Integer warrantyMonths;

    private Float totalRating;
    private List<Review> reviews;

    private static long idCount = 0;

    public Product(String name, String description, BigDecimal price,
                   Brand brand, Category category, Float weight, String technicalSpecs,
                   Integer warrantyMonths, Integer stockQuantity) {

        // lançar exception caso o produto já exista

        this.name = name;
        this.description = description;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.weight = weight;
        this.technicalSpecs = technicalSpecs;
        this.warrantyMonths = warrantyMonths;
        this.stockQuantity = stockQuantity;

        this.id = idCount;
        idCount++;

        System.out.println("Produto nº" + this.id + " criado com sucesso");
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
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
