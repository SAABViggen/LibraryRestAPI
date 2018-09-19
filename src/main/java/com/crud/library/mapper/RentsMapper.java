package com.crud.library.mapper;

import com.crud.library.controller.CopyNotFoundException;
import com.crud.library.controller.ReaderNotFoundException;
import com.crud.library.domain.Rents;
import com.crud.library.domain.RentsDto;
import com.crud.library.domain.dao.CopyDao;
import com.crud.library.domain.dao.ReaderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentsMapper {

    @Autowired
    CopyDao copyDao;
    @Autowired
    ReaderDao readerDao;

    public Rents mapToRent(final RentsDto rentsDto) throws CopyNotFoundException, ReaderNotFoundException {
        return new Rents(
                copyDao.findById(rentsDto.getCopyId()).orElseThrow(CopyNotFoundException::new),
                readerDao.findById(rentsDto.getReaderId()).orElseThrow(ReaderNotFoundException::new),
                rentsDto.getRentDate(),
                rentsDto.getReturnDate()
        );
    }
}