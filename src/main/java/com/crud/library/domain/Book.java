package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "pub_year")
    private Integer pubYear;

    @OneToMany(
            targetEntity = Copy.class,
            mappedBy = "bookId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Copy> copies;

    public Book(String title, String author, Integer pubYear) {
        this.title = title;
        this.author = author;
        this.pubYear = pubYear;
    }
}