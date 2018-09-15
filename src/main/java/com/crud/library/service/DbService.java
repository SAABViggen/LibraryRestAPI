package com.crud.library.service;

import com.crud.library.controller.BookNotFoundException;
import com.crud.library.domain.Book;
import com.crud.library.domain.Copy;
import com.crud.library.domain.Reader;
import com.crud.library.domain.dao.BookDao;
import com.crud.library.domain.dao.CopyDao;
import com.crud.library.domain.dao.ReaderDao;
import com.crud.library.domain.dao.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private CopyDao copyDao;
    @Autowired
    private ReaderDao readerDao;

/*    public List<Book> searchBookByTitle(String title) {
        return bookDao.searchBookByTitle(title);
    }

    public List<Book> searchBookByAuthor(String author) {
        return bookDao.searchBookByAuthor(author);
    }

    public List<Book> searchBook(String query) {
        return bookDao.searchBook(query);
    }*/

    public Book saveBook(final Book book) {
        return bookDao.save(book);
    }

    public void deleteBook(final Long id) {
        bookDao.delete(id);
    }

    public Optional<Book> getBook(final Long id) throws BookNotFoundException {
        return Optional.ofNullable(bookDao.findById(id)).orElseThrow(BookNotFoundException::new);
    }

    public List<Book> search(final List<SearchCriteria> query) {
        return bookDao.search(query);
    }

    public Copy saveCopy(final Copy copy) {
        return copyDao.save(copy);
    }

    public void deleteCopy(final Long id) {
        copyDao.delete(id);
    }

    public List<Copy> getAllCopies(final Long bookId) throws BookNotFoundException {
        return getBook(bookId).isPresent() ? getBook(bookId).get().getCopies() : new ArrayList<>();
    }

    public Reader saveReader(final Reader reader) {
        return readerDao.save(reader);
    }

    public void deleteReader(final Long id) {
        readerDao.delete(id);
    }
}