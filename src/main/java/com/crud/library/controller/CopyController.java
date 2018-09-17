package com.crud.library.controller;

import com.crud.library.domain.Copy;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/copy")
public class CopyController {

    @Autowired
    DbService service;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createCopy(@RequestBody Copy copy) {
        service.saveCopy(copy);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Copy updateCopy(@RequestBody Copy copy) {
        return service.saveCopy(copy);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{copyId}")
    public void deleteCopy(@PathVariable Long copyId) {
        service.deleteCopy(copyId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public void getAllCopies(@PathVariable Long bookId) throws BookNotFoundException {
        service.getAllCopies(bookId);
    }
}