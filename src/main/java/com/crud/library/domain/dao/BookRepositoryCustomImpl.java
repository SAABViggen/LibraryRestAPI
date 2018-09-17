package com.crud.library.domain.dao;

import com.crud.library.domain.Book;
import com.crud.library.domain.SearchBookDto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> filterBy(SearchBookDto searchBookDto) {
        if (searchBookDto.getTitle() == null && searchBookDto.getAuthor() == null) {
            return new ArrayList<>();
        }

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root book = query.from(Book.class);
        CriteriaQuery select = query.select(book);
        if (searchBookDto.getTitle() != null) {
            select.where(builder.equal(book.get("title"), searchBookDto.getTitle()));
        }
        if (searchBookDto.getAuthor() != null) {
            select.where(builder.equal(book.get("author"), searchBookDto.getAuthor()));
        }

        return entityManager.createQuery(query).getResultList();
    }
}