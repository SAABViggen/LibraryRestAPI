package com.crud.library.controller;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import com.crud.library.domain.SearchBookDto;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/books")
public class BookController {

    @Autowired
    private DbService service;
    @Autowired
    private BookMapper mapper;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Book createBook(@RequestBody BookDto bookDto) {
        return service.saveBook(mapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return mapper.mapToBookDto(service.saveBook(mapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        service.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) throws BookNotFoundException {
        return mapper.mapToBookDto(service.getBook(bookId).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<BookDto> searchBook(SearchBookDto searchBookDto) {
        return mapper.mapToBookDtoList(service.search(searchBookDto));
    }

    // Temporary
    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBooks() {
        return service.getBooks();
    }
}