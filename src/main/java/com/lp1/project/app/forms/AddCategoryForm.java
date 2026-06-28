package com.lp1.project.app.forms;

import com.lp1.project.app.App;
import com.lp1.project.app.screens.AddCategoryScreen;
import com.lp1.project.domain.category.Category;
import com.lp1.project.domain.repository.CategoryRepository;

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

        while(op != 1 && op != 2){
            System.out.print("\nOpcão inválida. Tente novamente.\n: ");
            op = App.SCANNER.nextInt();
        }
        App.SCANNER.nextLine();

        if (op == 1) {
            return null;
        }

        System.out.println("Adicionar categoria pai:");
        if(categories.isEmpty()){
            System.out.println("\nNenhuma categoria encontrada");
            System.out.print("1. Criar categoria pai\n2. Transformar essa categoria em categoria pai\n: ");

            op = App.SCANNER.nextInt();

            while(op != 1 && op != 2){
                System.out.println("\nOpção inválida. Tente novamente\n: ");
                op = App.SCANNER.nextInt();
            }
            App.SCANNER.nextLine();

            if(op==2){
                return null;
            }

            AddCategoryScreen.show();

            categories = App.getCategoryRepository().findAll();
            System.out.println("\nCategorias:");
            for(Category category : categories){
                System.out.println(category.getId() + " - " + category.getName());
            }

            System.out.print("\nEscolha a categoria pai (ID): ");

            int id = App.SCANNER.nextInt();

            if(id < 1 || id > categories.size()){
                throw new IllegalArgumentException("\nCategoria inválida.");
            }

            return categories.get(id-1);
        }

        System.out.println("\nCategorias: ");
        for(Category category : categories){
            System.out.println(category.getId() + " - " + category.getName());
        }

        System.out.print("\nEscolha a categoria pai (ID) ou crie uma nova categoria pai (0): ");

        long id = App.SCANNER.nextInt();
        App.SCANNER.nextLine();

        long maxId;
        if (id == 0) {
            AddCategoryScreen.show();

            maxId = categories.stream()
                    .mapToLong(Category::getId)
                    .max()
                    .orElse(0);

            return categories.get((int)(maxId-1));
        }

        if(id < 1 || id > categories.size()){
            throw new IllegalArgumentException("\nCategoria inválida.");
        }

        return categories.get((int)id-1);
    }
}
