package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.review.Review;
import com.lp1.project.domain.user.Customer;

import java.util.List;

public class SeeOrdersReviewsScreen {
    public static void show() {
        System.out.println("\n=====REVIEWS=====");
        List<Review> reviews = App.getReviewRepository().findByUser(App.getSession().getCurrentUser());

        if (reviews.isEmpty()) {
            System.out.println("\nVocê ainda não fez nenhuma review.");
            App.wait3Seconds();
            CustomerMainScreen.show();
        }

        System.out.println("Reviews: ");
        for (Review review : reviews) {
            System.out.println(review);
        }

        App.wait3Seconds();
    }
}
