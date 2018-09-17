package com.crud.library.controller;

import com.crud.library.domain.Rents;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/rents")
public class RentsController {

    @Autowired
    DbService service;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createRent(@RequestBody Rents rent) {
        service.saveRent(rent);
        service.updateCopyStatus(rent, "rented");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void createReturn(@RequestBody Rents rent) {
        service.saveRent(rent);
        service.updateCopyStatus(rent, "available");
    }
}