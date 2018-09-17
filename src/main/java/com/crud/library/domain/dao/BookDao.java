package com.crud.library.domain.dao;

import com.crud.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface BookDao extends CrudRepository<Book, Long>, BookRepositoryCustom {

    Optional<Book> findById(Long id);

    @Override
    Book save(Book book);
}