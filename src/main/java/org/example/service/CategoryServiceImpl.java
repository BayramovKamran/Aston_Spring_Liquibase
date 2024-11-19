package org.example.service;

import org.example.model.Category;
import org.example.dao.CategoryDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryRepository) {
        this.categoryDao = categoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAllCategories() {
        return categoryDao.findAllCategories();
    }

    @Override
    @Transactional(readOnly = true)
    public Category findCategoryById(Long id) {
        return Optional.ofNullable(categoryDao.findCategoryById(id))
                .orElseThrow(() -> new IllegalArgumentException("Категория с ID " + id + " не найдена"));
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Категория не может быть null");
        }
        categoryDao.saveCategory(category);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        if (category == null || category.getId() == null) {
            throw new IllegalArgumentException("Категория или ID не может быть null");
        }
        categoryDao.updateCategory(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID категории не может быть null");
        }
        categoryDao.deleteCategory(id);
    }
}