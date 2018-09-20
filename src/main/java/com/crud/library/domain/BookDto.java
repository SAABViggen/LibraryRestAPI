package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BookDto {

    private Long id;
    private String title;
    private String authorName;
    private String authorSurname;
    private Integer publicationYear;
    private Integer copies;
}