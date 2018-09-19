package com.crud.library.controller;

import com.crud.library.domain.Reader;
import com.crud.library.domain.ReaderDto;
import com.crud.library.mapper.ReaderMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/reader")
public class ReaderController {

    @Autowired
    DbService service;
    @Autowired
    ReaderMapper mapper;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Reader createReader(@RequestBody ReaderDto readerDto) {
        readerDto.setAccountCreationDate(LocalDateTime.now());
        return service.saveReader(mapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Reader updateReader(@RequestBody ReaderDto readerDto) {
        return service.saveReader(mapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{readerId}")
    public void deleteReader(@PathVariable Long readerId) {
        service.deleteReader(readerId);
    }

    // Temporary
    @RequestMapping(method = RequestMethod.GET)
    public List<Reader> getReaders() {
        return service.getReaders();
    }
}