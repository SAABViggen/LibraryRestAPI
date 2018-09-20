package com.crud.library.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "rents")
public class Rents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "copy_id")
    private Copy copyId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "reader_id")
    private Reader readerId;

    @Column(name = "rent_date")
    private LocalDateTime rentDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;
}