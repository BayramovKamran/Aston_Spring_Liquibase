package org.example.service;

import org.example.model.Author;
import org.example.dao.AuthorDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAllAuthors() {
        return authorDao.findAllAuthors();
    }

    @Override
    @Transactional(readOnly = true)
    public Author findAuthorById(Long id) {
        return Optional.ofNullable(authorDao.findAuthorById(id))
                .orElseThrow(() -> new IllegalArgumentException("Автор с ID " + id + " не найден"));
    }

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Автор не может быть null");
        }
        authorDao.saveAuthor(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        if (author == null || author.getId() == null) {
            throw new IllegalArgumentException("Автор или ID не может быть null");
        }
        authorDao.updateAuthor(author);
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID автора не может быть null");
        }
        authorDao.deleteAuthor(id);
    }
}