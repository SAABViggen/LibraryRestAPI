package com.crud.library.controller;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import com.crud.library.domain.dao.SearchCriteria;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/book")
public class BookController {

    @Autowired
    DbService service;
    @Autowired
    BookMapper bookMapper;

/*    @RequestMapping(method = RequestMethod.GET)
    public List<BookDto> searchBookByTitle(@RequestParam String title) {
        return bookMapper.mapToBookDtoList(service.searchBookByTitle(title));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookDto> searchBookByAuthor(@RequestParam String author) {
        return bookMapper.mapToBookDtoList(service.searchBookByAuthor(author));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookDto> searchBook(@RequestParam String query) {
        return bookMapper.mapToBookDtoList(service.searchBook(query));
    }*/

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody Book book) {
        service.saveBook(book);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BookDto updateBook(@RequestBody Book book) {
        return bookMapper.mapToBookDto(service.saveBook(book));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        service.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public Book getBook(@PathVariable Long bookId) throws BookNotFoundException {
        return service.getBook(bookId).orElseThrow(BookNotFoundException::new);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<BookDto> searchBook(@RequestParam List<SearchCriteria> query) {
        return bookMapper.mapToBookDtoList(service.search(query));
    }
}