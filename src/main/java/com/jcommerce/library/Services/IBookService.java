package com.jcommerce.library.Services;

import com.jcommerce.library.Entity.Book;

import java.util.List;
import java.util.Optional;

interface IBookService {

    public List<Book> findAll();

    public Optional<Book> findById(Long id);

    public Book save(Book book);

    public void deleteById(Long id);

}
