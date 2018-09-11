package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "account_creation_date")
    private LocalDateTime accountCreationDate;
}