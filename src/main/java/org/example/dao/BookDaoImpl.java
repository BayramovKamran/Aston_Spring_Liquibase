package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findAllBooks() {
        return entityManager.createQuery("FROM Book", Book.class).getResultList();
    }

    @Override
    public Book findBookById(Long id) {
    }

    @Override
    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }
}