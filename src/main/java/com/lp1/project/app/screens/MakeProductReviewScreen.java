package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.order.Order;
import com.lp1.project.domain.order.OrderItem;
import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.repository.ReviewRepository;
import com.lp1.project.domain.review.Review;
import com.lp1.project.domain.user.Customer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.lp1.project.domain.repository.ReviewRepository.addReview;

public class MakeProductReviewScreen {
    public static void review() {
        while(true) {
            System.out.println("\n=====AVALIAR PRODUTO=====");
            List<Order> orders = App.getOrderRepository().findOrdersWithoutReview((Customer) App.getSession().getCurrentUser());
            Set<Product> productsToReview = new HashSet<>();

            for (Order order : orders) {
                productsToReview.addAll(order.getItems()
                        .stream()
                        .map(OrderItem::getProduct)
                        .toList());
            }

            if (productsToReview.isEmpty()) {
                System.out.println("\nNenhum produto para avaliar.");
                App.wait3Seconds();
                SeePreviousOrdersScreen.show();
            }

            System.out.println("Produtos disponíveis para avaliar: ");

            for (Product product : productsToReview) {
                System.out.println(product.getId() + " - " + product.getName());
            }

            System.out.print("\nDigite o id do produto que você quer avaliar: ");

            long id = App.SCANNER.nextLong();
            App.SCANNER.nextLine();

            boolean exists = productsToReview.stream()
                    .anyMatch(p -> p.getId() == id);

            if (!exists) {
                System.out.println("\nVocê não pode avaliar esse produto.");
                App.wait3Seconds();
                continue;
            }

            Product product = productsToReview.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst().orElse(null);

            addReview(product);

            App.wait3Seconds();
            CustomerMainScreen.show();
        }
    }
}
