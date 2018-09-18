package com.crud.library.domain.dao;

import com.crud.library.domain.Book;
import com.crud.library.domain.SearchBookDto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> filterBy(SearchBookDto searchBookDto) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root book = query.from(Book.class);
        CriteriaQuery select = query.select(book);
        List<Predicate> predicates = new ArrayList<>();
        if (!searchBookDto.getTitle().isEmpty()) {
            predicates.add(builder.equal(book.get("title"), searchBookDto.getTitle()));
        }
        if (!searchBookDto.getAuthor().isEmpty()) {
            predicates.add(builder.equal(book.get("author"), searchBookDto.getAuthor()));
        }
        select.where(predicates.toArray(new Predicate[0]));


        return entityManager.createQuery(query).getResultList();
    }
}