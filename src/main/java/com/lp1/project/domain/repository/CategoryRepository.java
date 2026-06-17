package com.lp1.project.domain.repository;

import com.google.gson.reflect.TypeToken;
import com.lp1.project.domain.category.Category;

import java.util.List;

public class CategoryRepository extends JsonRepository<Category> {

    private static final String FILE_PATH = "data/categories.json";

    public CategoryRepository(){
        super(FILE_PATH, new TypeToken<List<Category>>(){}.getType());
        Category.synchronizeIdCounter(findAll());
    }

    public Category findById(long id){
        return items.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Category> findByParent(Category category){
        return items.stream()
                .filter(c -> c.getParentCategory().equals(category))
                .toList();
    }

}
