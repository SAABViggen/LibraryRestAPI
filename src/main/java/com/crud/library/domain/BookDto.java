package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private List<Copy> copies;
}