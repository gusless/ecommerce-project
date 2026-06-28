package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.review.Review;

import java.util.List;

public class SeeProductReviewScreen {
    public static void show() {
        while(true){
            System.out.println("\n=====REVIEWS DE PRODUTOS=====");
            System.out.println("Produtos com review:");

            List<Product> products = App.getProductRepository().findByAtLeastOneReview();

            if (products.isEmpty()){
                System.out.println("\nNenhum produto com review.");
                App.wait3Seconds();
                CustomerMainScreen.show();
            }

            for(Product product : products){
                System.out.println(product.getId() + " - " + product.getName() + " - " + product.getName() + " - " + product.getPrice());
            }

            System.out.print("Escolha o id do produto para ver as reviews: ");

            long id = App.SCANNER.nextInt();
            App.SCANNER.nextLine();

            Product product = products.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (product == null) {
                System.out.println("\nProduto inválido.");
                App.wait3Seconds();
                continue;
            }

            List<Review> reviews = App.getReviewRepository().findByProduct(id);

            System.out.println("\nReviews de " + product.getName());
            for(Review review : reviews){
                System.out.println(review);
            }

            System.out.println("\nPressione Enter para voltar...");
            App.SCANNER.nextLine();

            CustomerMainScreen.show();
        }


    }
}
