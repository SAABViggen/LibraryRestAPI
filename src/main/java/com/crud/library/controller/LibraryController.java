package com.crud.library.controller;

import com.crud.library.domain.BookDto;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    @Autowired
    DbService service;
    @Autowired
    BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET, value = "searchBookByTitle")
    public List<BookDto> searchBookByTitle(@RequestParam String title) {
        return bookMapper.mapToBookDtoList(service.searchBookByTitle(title));
    }

    @RequestMapping(method = RequestMethod.GET, value = "searchBookByAuthor")
    public List<BookDto> searchBookByAuthor(@RequestParam String author) {
        return bookMapper.mapToBookDtoList(service.searchBookByAuthor(author));
    }

    @RequestMapping(method = RequestMethod.GET, value = "searchBook")
    public List<BookDto> searchBook(@RequestParam String query) {
        return bookMapper.mapToBookDtoList(service.searchBook(query));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam Long bookId) {
        service.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public BookDto updateTask(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(service.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        service.saveBook(bookMapper.mapToBook(bookDto));
    }
}