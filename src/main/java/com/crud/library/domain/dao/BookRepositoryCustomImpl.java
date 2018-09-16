package com.crud.library.domain.dao;

import com.crud.library.domain.Book;
import com.crud.library.domain.SearchBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

        if (!searchBookDto.getTitle().isEmpty() && searchBookDto.getAuthor().isEmpty()) {
            query.select(book).where(builder.equal(book.get("title"), searchBookDto.getTitle()));
        } else if (!searchBookDto.getAuthor().isEmpty() && searchBookDto.getTitle().isEmpty()) {
            query.select(book).where(builder.equal(book.get("author"), searchBookDto.getAuthor()));
        } else if (!searchBookDto.getTitle().isEmpty() && !searchBookDto.getAuthor().isEmpty()) {
            query.multiselect(book).where(builder.equal(book.get("author"), searchBookDto.getAuthor()))
                    .where(builder.equal(book.get("title"), searchBookDto.getTitle()));

        } else {
            return new ArrayList<>();
        }

        return entityManager.createQuery(query).getResultList();
    }
}