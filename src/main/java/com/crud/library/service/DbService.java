package com.crud.library.service;

import com.crud.library.controller.BookNotFoundException;
import com.crud.library.domain.*;
import com.crud.library.domain.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookRepositoryCustomImpl bookRepository;
    @Autowired
    private CopyDao copyDao;
    @Autowired
    private ReaderDao readerDao;
    @Autowired
    private RentsDao rentsDao;
    @PersistenceContext
    private EntityManager entityManager;

    public Book saveBook(final Book book) {
        return bookDao.save(book);
    }

    public void deleteBook(final Long id) {
        bookDao.deleteById(id);
    }

    public Optional<Book> getBook(final Long id) throws BookNotFoundException {
        return Optional.ofNullable(bookDao.findById(id)).orElseThrow(BookNotFoundException::new);
    }

    public List<Book> search(final SearchBookDto searchBookDto) {
        return bookRepository.filterBy(searchBookDto);
    }

    public Copy saveCopy(final Copy copy) {
        return copyDao.save(copy);
    }

    public void deleteCopy(final Long id) {
        copyDao.deleteById(id);
    }

    public List<Copy> getAllCopies(final Long bookId) throws BookNotFoundException {
        return getBook(bookId).isPresent() ? getBook(bookId).get().getCopies() : new ArrayList<>();
    }

    public Copy updateCopyStatus(final Rents rent, String status) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Copy> criteria = builder.createCriteriaUpdate(Copy.class);
        Root<Copy> root = criteria.from(Copy.class);
        criteria.set(root.get("status"), status);
        criteria.where(builder.equal(root.get("id"), rent.getCopyId()));
        entityManager.createQuery(criteria).executeUpdate();

        return rent.getCopyId();
    }

    public Reader saveReader(final Reader reader) {
        return readerDao.save(reader);
    }

    public void deleteReader(final Long id) {
        readerDao.deleteById(id);
    }

    public Rents saveRent(final Rents rent) {
        return rentsDao.save(rent);
    }


}