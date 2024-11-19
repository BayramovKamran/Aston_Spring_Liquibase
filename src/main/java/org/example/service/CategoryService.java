package org.example.service;

import org.example.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategories();

    Category findCategoryById(Long id);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Long id);
}
