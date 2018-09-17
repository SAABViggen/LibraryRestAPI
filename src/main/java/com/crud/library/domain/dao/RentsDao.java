package com.crud.library.domain.dao;

import com.crud.library.domain.Rents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RentsDao extends CrudRepository<Rents, Long> {

    @Override
    Rents save(Rents rents);
}