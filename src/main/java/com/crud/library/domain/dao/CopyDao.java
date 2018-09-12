package com.crud.library.domain.dao;

import com.crud.library.domain.Copy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CopyDao extends CrudRepository<Copy, Long> {

    @Query
    int countCopies(@Param("BOOK_ID") Long bookId);

    @Override
    Copy save(Copy copy);

    void delete(Long id);
}