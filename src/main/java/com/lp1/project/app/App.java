package com.lp1.project.app;

import com.lp1.project.app.screens.MainMenuScreen;
import com.lp1.project.domain.category.CategoryService;
import com.lp1.project.domain.product.ProductService;
import com.lp1.project.domain.repository.CategoryRepository;
import com.lp1.project.domain.repository.ProductRepository;
import com.lp1.project.domain.repository.UserRepository;
import com.lp1.project.domain.user.Admin;
import com.lp1.project.domain.user.UserService;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static final Scanner SCANNER = new Scanner(System.in);

    private static final Session session = new Session();

    private static final UserRepository userRepository = new UserRepository();
    private static final UserService userService = new UserService(userRepository);
    private static final ProductRepository productRepository = new ProductRepository();
    private static final ProductService productService = new ProductService(productRepository);
    private static final CategoryRepository categoryRepository = new CategoryRepository();
    private static final CategoryService categoryService = new CategoryService(categoryRepository);

    public static UserService getUserService() {
        return userService;
    }

    public static Session getSession() {
        return session;
    }

    public static ProductService getProductService() {return productService;}

    public static CategoryService getCategoryService() {return categoryService;}

    public static CategoryRepository getCategoryRepository() {return categoryRepository;}

    public static void run() {
        createDefaultAdmin(userRepository);
        MainMenuScreen.show();
    }

    public static void createDefaultAdmin(UserRepository repository) {
        if (repository.findByEmail("admin@loja.com") == null) {
            repository.save(new Admin(
                    "Administrador",
                    LocalDate.of(1990, 1, 1),
                    "12345678901",
                    "admin@loja.com",
                    "Admin@123",
                    "84999999999"
            ));
        }
    }
}
