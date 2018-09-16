package com.crud.library.domain.dao;

import com.crud.library.domain.Book;
import com.crud.library.domain.SearchBookDto;

import java.util.List;

public interface BookRepositoryCustom {

    List<Book> filterBy(SearchBookDto searchBookDto);
}