package org.example.service;

import org.example.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();

    Book findBookById(Long id);

    void saveBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);
}