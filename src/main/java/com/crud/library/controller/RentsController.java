package com.crud.library.controller;

import com.crud.library.domain.Rents;
import com.crud.library.domain.RentsDto;
import com.crud.library.mapper.RentsMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/rents")
public class RentsController {

    @Autowired
    private DbService service;
    @Autowired
    private RentsMapper mapper;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Rents rentBook(@RequestBody RentsDto rentDto) throws CopyNotFoundException, ReaderNotFoundException {
        return service.rentBook(mapper.mapToRent(rentDto));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Rents returnBook(@RequestBody RentsDto rentDto) throws CopyNotFoundException, ReaderNotFoundException {
        return service.returnBook(mapper.mapToRent(rentDto));
    }

    // Temporary
    @RequestMapping(method = RequestMethod.GET)
    public List<Rents> getRents() {
        return service.getRents();
    }
}