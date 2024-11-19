package org.example.service;

import org.example.model.Book;
import org.example.dao.BookDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAllBooks() {
        return bookDao.findAllBooks();
    }

    @Override
    @Transactional(readOnly = true)
    public Book findBookById(Long id) {
        return Optional.ofNullable(bookDao.findBookById(id))
                .orElseThrow(() -> new IllegalArgumentException("Книга с ID " + id + " не найдена"));
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Книга не может быть null");
        }
        bookDao.saveBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        if (book == null || book.getId() == null) {
            throw new IllegalArgumentException("Книга или ID не может быть null");
        }
        bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID книги не может быть null");
        }
        bookDao.deleteBook(id);
    }
}