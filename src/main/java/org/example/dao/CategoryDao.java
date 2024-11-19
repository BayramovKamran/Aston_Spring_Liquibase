package org.example.dao;

import org.example.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findAllCategories();

    Category findCategoryById(Long id);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Long id);
}

