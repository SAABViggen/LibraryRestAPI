package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@NamedQuery(
        name = "Copy.countCopies",
        query = "COUNT(*) FROM Copy WHERE book_ID = :BOOK_ID"
)
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "copies")
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "book_ID")
    private Book bookId;

    @Column(name = "status")
    private String status;
}