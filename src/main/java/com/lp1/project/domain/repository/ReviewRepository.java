package com.lp1.project.domain.repository;

import com.google.gson.reflect.TypeToken;
import com.lp1.project.app.App;
import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.review.Review;
import com.lp1.project.domain.user.Customer;
import com.lp1.project.domain.user.User;

import java.util.List;

public class ReviewRepository extends JsonRepository<Review> {
    private static final String FILE_PATH = "data/reviews.json";

    public ReviewRepository() {
        super(FILE_PATH, new TypeToken<List<Review>>(){}.getType());
        Review.synchronizeIdCounter(findAll());
    }

    public Review findById(long id) {
        return items.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Review> findByUser(User user) {
        return items.stream()
                .filter(r -> r.getUser().getId() == user.getId())
                .toList();
    }

    public List<Review> findByProduct(long productId) {
        return items.stream()
                .filter(r -> r.getProduct().getId() == productId)
                .toList();
    }

    public static void addReview(Product product) {

        Customer customer = (Customer) App.getSession().getCurrentUser();

        System.out.print("Nota (1 a 5): ");
        int stars = App.SCANNER.nextInt();
        App.SCANNER.nextLine();

        System.out.print("Título: ");
        String title = App.SCANNER.nextLine();

        System.out.print("Comentário: ");
        String comment = App.SCANNER.nextLine();

        Review review = new Review(customer.getId(), stars, product, title, comment);

        App.getReviewRepository().save(review);

        product.addReview(review.getId());

        customer.addReview(review.getId());
        App.getUserRepository().update();
        App.getProductRepository().update();


        System.out.println("\nReview adicionada com sucesso.");
    }
}
