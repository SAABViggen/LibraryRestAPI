package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
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

    public Rents(Copy copyId, Reader readerId, LocalDateTime rentDate, LocalDateTime returnDate) {
        this.copyId = copyId;
        this.readerId = readerId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }
}