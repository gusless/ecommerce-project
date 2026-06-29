package com.lp1.project.app.screens.admin;

import com.lp1.project.app.App;
import com.lp1.project.domain.product.Product;

import java.util.ArrayList;
import java.util.List;

public class AddStockScreen {
    public static void show() {
        while(true) {
            System.out.println("\n=====ADICIONAR ESTOQUE=====");
            List<Product>  products = App.getProductRepository().findAll();

            System.out.println("Produtos:");
            for(Product product : products){
                System.out.println(product.getId() + " - " + product.getName() + " - " + product.getStockQuantity());
            }

            System.out.print("\nEscolha o id do produto para adicionar estoque: ");

            Long id = App.SCANNER.nextLong();
            App.SCANNER.nextLine();

            if (id < 1 || id > products.size()) {
                System.out.println("\nProduto inválido.");
                continue;
            }

            System.out.print("Quanto deve ser adicionado ao estoque de " +
                    App.getProductRepository().findById(id).getName() + "?\n: ");

            int op = App.SCANNER.nextInt();
            App.SCANNER.nextLine();

            if (op < 1) {
                throw new IllegalArgumentException("\nValor inválido para adicionar ao estoque.");
            }

            App.getProductRepository().findById(id).addStock(op);

            App.getProductRepository().update();

            System.out.println("\nEstoque adicionado com sucesso.");
            AdminMainScreen.show();

        }
    }
}
