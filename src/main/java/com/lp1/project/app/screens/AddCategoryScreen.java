package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.app.forms.AddCategoryForm;
import com.lp1.project.domain.category.Category;
import com.lp1.project.domain.category.CategoryService;

public class AddCategoryScreen {
    private static final CategoryService service = App.getCategoryService();
    public static void show() {
        try {
            System.out.println("\n=====ADICIONAR CATEGORIA=====");
            String name = AddCategoryForm.name();
            String description = AddCategoryForm.description();
            Category parentCategory = AddCategoryForm.parentCategory();

            Category newCategory = new Category(name, description, parentCategory);

            service.createCategory(App.getSession().getCurrentUser(), newCategory);

            System.out.println("\nCategoria criada com sucesso.");

            AdminMainScreen.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (App.SCANNER.hasNextLine()) {
                App.SCANNER.nextLine();
            }
        }

    }
}
