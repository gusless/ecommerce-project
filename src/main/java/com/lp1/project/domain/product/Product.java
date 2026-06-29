package com.lp1.project.domain.product;

import com.lp1.project.app.App;
import com.lp1.project.domain.category.Category;
import com.lp1.project.domain.review.Review;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private long id;
    private String name;
    private String description;
    private Integer stockQuantity;
    private BigDecimal price;
    private Category category;
    private Float weight;
    private String technicalSpecs;
    private Integer warrantyMonths;

    private Float totalRating;
    private List<Long> reviewsIds;

    private static long idCount = 1;

    public Product(String name, String description, BigDecimal price,
                   Category category, Float weight, String technicalSpecs,
                   Integer warrantyMonths, Integer stockQuantity) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.weight = weight;
        this.technicalSpecs = technicalSpecs;
        this.warrantyMonths = warrantyMonths;
        this.stockQuantity = stockQuantity;

        this.reviewsIds = new ArrayList<>();
        this.totalRating = 0f;

        this.id = idCount;
        idCount++;
    }

    @Override
    public String toString() {
        return "id" + id +
                "\nNome: " + name + " - R$" + price +
                "\nEstoque: " + stockQuantity + " Peso: " + weight + "kg" +
                "\nDescrição:\n" + description +
                "\nEspecificações técnicas:\n" + technicalSpecs +
                "\nCategoria: " + category.getName() +
                "\nMeses de Garantia: " + warrantyMonths +
                "\nAvaliação dos usuários: " + totalRating;
    }

    public static void synchronizeIdCounter(List<Product> products) {
        long maxId = products.stream()
                .mapToLong(Product::getId)
                .max()
                .orElse(0);

        idCount = maxId + 1;
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

    public void decreaseStockQuantity(Integer quantity) {
        if (quantity > stockQuantity) {
            throw new RuntimeException("\nEstoque insuficiente do produto " + name);
        }

        this.stockQuantity -= quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Float getWeight() {
        return weight;
    }

    public Float getTotalRating() {
        return totalRating;
    }

    public void addReview(Long reviewId) {
        reviewsIds.add(reviewId);
        updateTotalRating();
    }

    public void updateTotalRating() {
        List<Review> reviews = getReviews();

        if(reviews.isEmpty()){
            totalRating = 0f;
            return;
        }

        float sum = 0f;

        for (Review review : reviews) {
            sum += review.getStars();
        }

        totalRating = sum / reviews.size();
    }

    public void addStock(Integer value) {
        this.stockQuantity += value;
    }

    public List<Review> getReviews() {
        return App.getReviewRepository().findByProduct(this.id);
    }

    public Integer getWarrantyMonths() {
        return warrantyMonths;
    }


}
