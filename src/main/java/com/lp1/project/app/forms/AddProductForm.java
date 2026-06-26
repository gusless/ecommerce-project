package com.lp1.project.app.forms;


import com.lp1.project.app.App;
import com.lp1.project.app.screens.AddCategoryScreen;
import com.lp1.project.domain.category.Category;

import java.math.BigDecimal;
import java.util.List;

public class AddProductForm {
    public static String name() {
        System.out.println("Nome do produto: ");
        return App.SCANNER.nextLine();
    }

    public static String description() {
        System.out.println("Descrição do produto: ");
        return App.SCANNER.nextLine();
    }

    public static Integer stockQuantity() {
        System.out.println("Quantidade em estoque: ");
        return App.SCANNER.nextInt();
    }

    public static BigDecimal price() {
        System.out.println("Preço unitário: ");
        return App.SCANNER.nextBigDecimal();
    }

    public static Category category() {
        List<Category> categories = App.getCategoryRepository().findAll();

        // Se estiver vazio ir para tela de adicionar categoria
        if (categories.isEmpty()) {
            System.out.println("\nNenhuma categoria foi encontrada, adicione uma nova:");
            AddCategoryScreen.show();
        }
        System.out.println("Categorias:");

        categories = App.getCategoryRepository().findAll();
        for (Category category : categories) {
            System.out.println(category.getId() + " - " + category.getName());
        }

        System.out.println("Escolha uma categoria (ID) ou crie uma nova categoria (0):");
        System.out.print(": ");

        long id = App.SCANNER.nextLong();
        App.SCANNER.nextLine();

        long maxId;
        if (id == 0) {
            AddCategoryScreen.show();

            maxId = categories.stream()
                    .mapToLong(Category::getId)
                    .max()
                    .orElse(0);

            return categories.get((int) maxId-1);
        }

        if (id < 1 || id > categories.size()) {
            throw new RuntimeException("Categoria inválida");
        }

        return categories.get((int) id-1);
    }

    public static Float weight() {
        System.out.println("Peso do produto: ");
        return App.SCANNER.nextFloat();
    }

    public static String technicalSpecs() {
        System.out.println("Especificações técnicas: ");
        return App.SCANNER.nextLine();
    }

    public static Integer warrantyMonths() {
        System.out.println("Meses de garantia: ");
        return App.SCANNER.nextInt();
    }
}
