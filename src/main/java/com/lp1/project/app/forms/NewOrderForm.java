package com.lp1.project.app.forms;

import com.lp1.project.app.App;
import com.lp1.project.domain.product.Product;

import java.util.List;

public class NewOrderForm {
    public static Product product() {
        List<Product> products = App.getProductRepository().findProductsInStock();

        System.out.println("Produtos:");
        for (Product product : products) {
            System.out.println(product.getId() + " - " + product.getName() + " - R$ " + product.getPrice());
        }

        System.out.print("\nEscolha o produto para adicionar no carrinho (ID) ou 0 para cancelar: ");
        int id = App.SCANNER.nextInt();
        App.SCANNER.nextLine();

        if (id == 0) {
            return null;
        }

        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("\nProduto inválido."));
    }

    public static Integer quantity(Product product) {
        System.out.println(product);
        System.out.print("\nEscolha a quantidade ou 0 caso queira escolher outro produto: ");

        return App.SCANNER.nextInt();
    }
}
