package com.jcommerce.library.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long Id;

    private String Title;

    private String Author;

    @Column(name = "reader_id")
    private Long readerId;
}
