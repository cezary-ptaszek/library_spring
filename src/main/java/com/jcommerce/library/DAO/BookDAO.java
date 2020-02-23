package com.jcommerce.library.DAO;

import com.jcommerce.library.Entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book book);

    void deleteById(Long id);

}
