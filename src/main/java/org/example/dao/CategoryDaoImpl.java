package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> findAllCategories() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }

    @Override
    public Category findCategoryById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public void saveCategory(Category category) {
        entityManager.persist(category);
    }

    @Override
    public void updateCategory(Category category) {
        entityManager.merge(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = entityManager.find(Category.class, id);
        if (category != null) {
            entityManager.remove(category);
        }
    }
}