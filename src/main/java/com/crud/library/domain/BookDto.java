package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private int copies;
}