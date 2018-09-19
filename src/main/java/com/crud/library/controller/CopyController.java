package com.crud.library.controller;

import com.crud.library.domain.Copy;
import com.crud.library.domain.CopyDto;
import com.crud.library.mapper.CopyMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library/copy")
public class CopyController {

    @Autowired
    DbService service;
    @Autowired
    CopyMapper mapper;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createCopy(@RequestBody CopyDto copyDto) throws BookNotFoundException {
        service.saveCopy(mapper.mapToCopy(copyDto));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Copy updateCopy(@RequestBody CopyDto copyDto) throws BookNotFoundException {
        return service.saveCopy(mapper.mapToCopy(copyDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{copyId}")
    public void deleteCopy(@PathVariable Long copyId) {
        service.deleteCopy(copyId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public void getAllCopies(@PathVariable Long bookId) throws BookNotFoundException {
        service.getAllCopies(bookId);
    }

    // Temporary
    @RequestMapping(method = RequestMethod.GET)
    public List<Copy> getCopies() {
        return service.getCopies();
    }
}