package com.crud.library.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SearchBookDto implements Serializable {

    private String title, authorName, authorSurname;
}