package com.jcommerce.library.Entity;

import lombok.*;

import javax.persistence.*;


@Entity
@EqualsAndHashCode
@ToString
@Table(name = "books")
public class Book {

    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Long reader;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getReader() {
        return reader;
    }

    public void setReader(Long reader) {
        this.reader = reader;
    }
}
