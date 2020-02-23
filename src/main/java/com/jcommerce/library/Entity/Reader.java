package com.jcommerce.library.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "reader_id", nullable = false)
    private Long Id;

    private String Name;

    private String Surname;
}
