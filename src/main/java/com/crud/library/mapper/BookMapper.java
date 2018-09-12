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
                bookDto.getCopyDao(),
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear(),
                bookDto.getCopies());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getCopyDao(),
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear(),
                book.getCopies());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> books) {
        return books.stream()
                .map(book -> new BookDto(book.getCopyDao(), book.getId(), book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getCopies()))
                .collect(Collectors.toList());
    }
}