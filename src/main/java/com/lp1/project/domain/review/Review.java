package com.lp1.project.domain.review;

import com.lp1.project.app.App;
import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.user.User;

import java.time.LocalDateTime;
import java.util.List;

public class Review {
    private long id;
    private Long userId;
    private Integer stars;
    private Product product;
    private String title;
    private String comment;
    private LocalDateTime dateReview;

    private static long idCount = 1;

    public Review(Long userId, Integer stars, Product product, String title, String comment) {
        this.userId = userId;
        this.stars = stars;
        this.product = product;
        this.title = title;
        this.comment = comment;

        this.dateReview = LocalDateTime.now();

        this.id = idCount;
        idCount++;
    }

    public static void synchronizeIdCounter(List<Review> reviews) {
        long maxId = reviews.stream()
                .mapToLong(Review::getId)
                .max()
                .orElse(0);

        idCount = maxId + 1;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return App.getUserRepository().findById(this.userId);
    }

    public Integer getStars() {
        return stars;
    }

    public Product getProduct() {
        return product;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getDateReview() {
        return dateReview;
    }

    @Override
    public String toString() {
        return "Produto: " + this.product.getName() +
                " - Preço: R$ " + this.product.getPrice() +
                "\nTítulo: " + this.title +
                "\nComentário:\n" + this.comment;
    }
}
