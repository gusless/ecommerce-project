package com.lp1.project.app.screens;

import com.lp1.project.app.App;
import com.lp1.project.app.forms.AddProductForm;
import com.lp1.project.domain.category.Category;
import com.lp1.project.domain.product.Product;
import com.lp1.project.domain.product.ProductService;

import java.math.BigDecimal;

public class AddProductScreen {
    private static final ProductService service = App.getProductService();

    public static void show() {
        while(true){
            try {
                System.out.println("\n=====ADICIONAR PRODUTO=====");
                String name = AddProductForm.name();
                String description = AddProductForm.description();
                Integer stockQuantity = AddProductForm.stockQuantity();
                BigDecimal price = AddProductForm.price();
                App.SCANNER.nextLine();
                Category category = AddProductForm.category();
                Float weight = AddProductForm.weight();
                App.SCANNER.nextLine();
                String technicalSpecs = AddProductForm.technicalSpecs();
                Integer warrantyMonths = AddProductForm.warrantyMonths();
                App.SCANNER.nextLine();

                Product newProduct = new Product(name, description, price, category, weight, technicalSpecs, warrantyMonths, stockQuantity);

                service.createProduct(App.getSession().getCurrentUser(), newProduct);

                System.out.println("\nProduto criado com sucesso");

                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
