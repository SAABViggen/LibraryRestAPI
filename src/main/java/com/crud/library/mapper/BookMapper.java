package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear(),
                bookDto.getCopies());
    }

    public BookDto mapToBookDto(final Book task) {
        return new BookDto(
                task.getId(),
                task.getTitle(),
                task.getAuthor(),
                task.getPublicationYear(),
                task.getCopies());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> books) {
        return books.stream()
                .map(t -> new BookDto(t.getId(), t.getTitle(), t.getAuthor(), t.getPublicationYear(), t.getCopies()))
                .collect(Collectors.toList());
    }
}