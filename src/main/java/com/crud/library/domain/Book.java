package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Book.searchBookByTitle",
                query = "FROM Book WHERE title LIKE CONCAT ('%', :TITLE, '%')"
        ),
        @NamedQuery(
                name = "Book.searchBookByAuthor",
                query = "FROM Book WHERE author LIKE CONCAT ('%', :AUTHOR, '%')"
        ),
        @NamedQuery(
                name = "Book.searchBook",
                query = "FROM Book WHERE title LIKE CONCAT ('%', :QUERY, '%') " +
                        "OR author LIKE CONCAT ('%', :QUERY, '%')"
        )
})
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publication_year")
    private int publicationYear;

    @OneToMany(
            targetEntity = Copy.class,
            mappedBy = "books",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Copy> copies;
}