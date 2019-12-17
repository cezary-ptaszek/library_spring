package com.jcommerce.library.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "books")
public class Book {

    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Title;
    private String Author;

    @ManyToOne
    @JoinColumn(name="bookId", referencedColumnName = "Id", insertable = false, nullable = true)
    private Reader ReaderId;
}
