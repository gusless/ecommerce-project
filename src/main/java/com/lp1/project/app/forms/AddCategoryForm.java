package com.lp1.project.app.forms;

import com.lp1.project.app.App;
import com.lp1.project.app.screens.admin.AddCategoryScreen;
import com.lp1.project.domain.category.Category;

import java.util.List;

public class AddCategoryForm {
    public static String name() {
        System.out.print("Nome da categoria: ");
        return App.SCANNER.nextLine();
    }

    public static String description() {
        System.out.println("Descrição da  categoria: ");
        return App.SCANNER.nextLine();
    }

    public static Category parentCategory() {
        List<Category> categories = App.getCategoryRepository().findAll();

        System.out.print("A categoria é uma categoria pai?\n1. Sim\n2. Não\n: ");

        int op = App.SCANNER.nextInt();
        App.SCANNER.nextLine();

        while (op != 1 && op != 2) {
            System.out.print("\nOpcão inválida. Tente novamente.\n: ");
            op = App.SCANNER.nextInt();
            App.SCANNER.nextLine();
        }

        if (op == 1) {
            return null;
        }

        System.out.println("\nCategorias: ");
        for (Category category : categories) {
            System.out.println(category.getId() + " - " + category.getName());
        }

        System.out.print("\nEscolha a categoria pai (id) ou 0 para nenhuma: ");
        long id = App.SCANNER.nextLong();
        App.SCANNER.nextLine();

        if (id == 0) {
            return null;
        }

        return categories.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("\nCategoria inválida."));

    }
}
