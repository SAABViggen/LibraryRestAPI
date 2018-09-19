package com.crud.library.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CopyDto {

    private Long id;
    private Long bookId;
    private String status;
}