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
    DbService service;
    @Autowired
    RentsMapper mapper;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createRent(@RequestBody RentsDto rentDto) throws CopyNotFoundException, ReaderNotFoundException {
        service.saveRent(mapper.mapToRent(rentDto));
        service.updateCopyStatus(mapper.mapToRent(rentDto), "rented");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void createReturn(@RequestBody RentsDto rentDto) throws CopyNotFoundException, ReaderNotFoundException {
        service.saveRent(mapper.mapToRent(rentDto));
        service.updateCopyStatus(mapper.mapToRent(rentDto), "available");
    }

    // Temporary
    @RequestMapping(method = RequestMethod.GET)
    public List<Rents> getRents() {
        return service.getRents();
    }
}