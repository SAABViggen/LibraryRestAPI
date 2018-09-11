package com.crud.library.repository;

import com.crud.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface LibraryRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();

    Optional<Book> findById(Long id);

    @Override
    Book save(Book book);

    @Override
    long count();
}