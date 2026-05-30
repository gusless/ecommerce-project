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
    private Integer likes;
    private LocalDateTime dateReview;
}
