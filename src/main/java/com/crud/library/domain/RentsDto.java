package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RentsDto {

    private Long copyId;
    private Long readerId;
    private LocalDateTime rentDate;
    private LocalDateTime returnDate;
}