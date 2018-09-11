package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DbService {

    @Autowired
    private LibraryRepository repository;

    private List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBook(final Long id) {
        return repository.findById(id);
    }

    public List<Book> searchBook(final String str) {
        return getAllBooks().stream()
                .filter(t -> t.getAuthor().toLowerCase().contains(str.toLowerCase())
                        || t.getTitle().toLowerCase().contains(str.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Book saveBook(final Book book) {
        return repository.save(book);
    }

    public void deleteBook(final Long id) {
        repository.delete(id);
    }
}