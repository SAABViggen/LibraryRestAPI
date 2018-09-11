package com.crud.library.domain.dao;

import com.crud.library.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BookDao extends CrudRepository<Book, Long> {

    @Query
    List<Book> searchBookByTitle(@Param("TITLE") String title);

    @Query
    List<Book> searchBookByAuthor(@Param("AUTHOR") String author);

    @Query
    List<Book> searchBook(@Param("QUERY") String query);
}