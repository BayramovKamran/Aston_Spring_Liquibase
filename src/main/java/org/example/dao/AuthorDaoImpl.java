package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> findAllAuthors() {
        return entityManager.createQuery("FROM Author", Author.class).getResultList();
    }

    @Override
    public Author findAuthorById(Long id) {
    }

    @Override
    public void saveAuthor(Author author) {
        entityManager.persist(author);
    }

    @Override
    public void updateAuthor(Author author) {
        entityManager.merge(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = entityManager.find(Author.class, id);
        entityManager.remove(author);
    }
}