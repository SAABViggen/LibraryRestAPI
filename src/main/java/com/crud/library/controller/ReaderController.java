package com.crud.library.controller;

import com.crud.library.domain.Reader;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/reader")
public class ReaderController {

    @Autowired
    DbService service;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody Reader reader) {
        service.saveReader(reader);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Reader updateReader(@RequestBody Reader reader) {
        return service.saveReader(reader);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{readerId}")
    public void deleteReader(@PathVariable Long readerId) {
        service.deleteReader(readerId);
    }
}