package com.crud.library.domain.dao;

import lombok.Getter;

@Getter
public class SearchCriteria {

    private String key;
    private String operation;
    private Object value;
}