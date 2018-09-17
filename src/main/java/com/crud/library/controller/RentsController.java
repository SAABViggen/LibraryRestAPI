package com.crud.library.controller;

import com.crud.library.domain.Rents;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/rents")
public class RentsController {

    @Autowired
    DbService service;

    public void createRent(Rents rent) {
        service.updateCopyStatus(rent);
        service.saveRent(rent);
    }
}