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

}
