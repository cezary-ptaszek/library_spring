package com.jcommerce.library.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "readers")
public class Reader {

    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private String Surname;

    @OneToMany(targetEntity=Book.class, mappedBy="Id", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Book> BooksId;
}
