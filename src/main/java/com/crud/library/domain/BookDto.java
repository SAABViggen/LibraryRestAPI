package com.crud.library.domain;

import com.crud.library.domain.dao.CopyDao;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class BookDto {

    @Autowired
    CopyDao copyDao;

    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    public int copiesNumber() {
        return copyDao.countCopies(id);
    }
    private List<Copy> copies;
}