package com.lp1.project.domain.review;

import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.user.User;

import java.time.LocalDateTime;

public class Review {
    private long id;
    private User user;
    private Integer stars;
    private Product product;
    private String title;
    private String comment;
    private LocalDateTime dateReview;

    private static long idCount = 1;

    public Review(User user, Integer stars, Product product, String title, String comment) {
        this.user = user;
        this.stars = stars;
        this.product = product;
        this.title = title;
        this.comment = comment;

        this.dateReview = LocalDateTime.now();

        this.id = idCount;
        idCount++;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
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
}
