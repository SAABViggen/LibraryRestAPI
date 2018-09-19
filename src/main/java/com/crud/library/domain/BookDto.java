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
    private String author;
    private Integer pubYear;
    private Integer copies;
}