package com.crud.library.mapper;

import com.crud.library.controller.BookNotFoundException;
import com.crud.library.domain.Copy;
import com.crud.library.domain.CopyDto;
import com.crud.library.domain.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CopyMapper {

    @Autowired
    BookDao bookDao;

    public Copy mapToCopy(final CopyDto copyDto) throws BookNotFoundException {
        return new Copy(
                copyDto.getId(),
                bookDao.findById(copyDto.getBookId()).orElseThrow(BookNotFoundException::new),
                copyDto.getStatus());
    }
}