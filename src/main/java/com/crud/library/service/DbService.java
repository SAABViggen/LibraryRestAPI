package com.crud.library.service;

import com.crud.library.controller.BookNotFoundException;
import com.crud.library.controller.CopyStatus;
import com.crud.library.domain.*;
import com.crud.library.domain.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    private CopyRepositoryCustomImpl copyRepository;
    @Autowired
    private ReaderDao readerDao;
    @Autowired
    private RentsDao rentsDao;

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
        Optional<Book> book = getBook(bookId);
        return book.isPresent() ? book.get().getCopies() : new ArrayList<>();
    }

    public Reader saveReader(final Reader reader) {
        return readerDao.save(reader);
    }

    public void deleteReader(final Long id) {
        readerDao.deleteById(id);
    }

    public Rents rentBook(final Rents rent) {
        rent.setRentDate(LocalDateTime.now());
        updateCopyStatus(rent, CopyStatus.RENTED.toString());
        return rentsDao.save(rent);
    }

    public Rents returnBook(final Rents rent) {
        rent.setReturnDate(LocalDateTime.now());
        updateCopyStatus(rent, CopyStatus.AVAILABLE.toString());
        return rentsDao.save(rent);
    }

    private void updateCopyStatus(final Rents rent, String status) {
        copyRepository.updateCopyStatus(rent, status);
    }

    // Temporary
    public List<Book> getBooks() {
        List<Book> result = new ArrayList<>();
        bookDao.findAll().forEach(result::add);
        return result;
    }

    public List<Copy> getCopies() {
        List<Copy> result = new ArrayList<>();
        copyDao.findAll().forEach(result::add);
        return result;
    }

    public List<Reader> getReaders() {
        List<Reader> result = new ArrayList<>();
        readerDao.findAll().forEach(result::add);
        return result;
    }

    public List<Rents> getRents() {
        List<Rents> result = new ArrayList<>();
        rentsDao.findAll().forEach(result::add);
        return result;
    }
}