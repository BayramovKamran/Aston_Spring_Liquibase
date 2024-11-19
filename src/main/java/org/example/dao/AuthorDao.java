package org.example.dao;

import org.example.model.Author;

import java.util.List;

public interface AuthorDao {

    List<Author> findAllAuthors();

    Author findAuthorById(Long id);

    void saveAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(Long id);
}

