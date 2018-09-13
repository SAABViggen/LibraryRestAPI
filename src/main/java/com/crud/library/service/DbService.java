package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.Copy;
import com.crud.library.domain.dao.BookDao;
import com.crud.library.domain.dao.CopyDao;
import com.crud.library.domain.dao.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private CopyDao copyDao;

/*    public List<Book> searchBookByTitle(String title) {
        return bookDao.searchBookByTitle(title);
    }

    public List<Book> searchBookByAuthor(String author) {
        return bookDao.searchBookByAuthor(author);
    }

    public List<Book> searchBook(String query) {
        return bookDao.searchBook(query);
    }*/

    public List<Book> search(List<SearchCriteria> query) {
        return bookDao.search(query);
    }

    public void deleteBook(Long id) {
        bookDao.delete(id);
    }

    public Book saveBook(Book book) {
        return bookDao.save(book);
    }

    public void deleteCopy(Long id) {
        copyDao.delete(id);
    }

    public Copy saveCopy(Copy copy) {
        return copyDao.save(copy);
    }
}