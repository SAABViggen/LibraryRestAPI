package com.crud.library.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReaderDto {

    private Long id;
    private String name;
    private String surname;
    private LocalDateTime accountCreationDate;
}