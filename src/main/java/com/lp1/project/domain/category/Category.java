package com.lp1.project.domain.category;

import java.util.List;

public class Category {
    private long id;
    private String name;
    private String description;
    private Category parentCategory;

    private static long idCount = 1;

    public Category(String name, String description, Category parentCategory) {
        this.name = name;
        this.description = description;
        this.parentCategory = parentCategory;

        this.id = idCount;
        idCount++;
    }

    @Override
    public String toString() {
        return "Categoria: " + name +
                " - id: " + id +
                "Descrição: " + description +
                "\nCategoria Pai: " + parentCategory;
    }

    public static void synchronizeIdCounter(List<Category> categories) {
        long maxId = categories.stream()
                .mapToLong(Category::getId)
                .max()
                .orElse(0);

        idCount = maxId + 1;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getParentCategory() {
        return parentCategory;
    }
}
