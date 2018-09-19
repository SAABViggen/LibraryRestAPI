package com.crud.library.mapper;

import com.crud.library.domain.Reader;
import com.crud.library.domain.ReaderDto;
import org.springframework.stereotype.Component;

@Component
public class ReaderMapper {

    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getName(),
                readerDto.getSurname(),
                readerDto.getAccountCreationDate()
        );
    }
}