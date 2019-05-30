package com.jcommerce.library.Services;

import com.jcommerce.library.Entity.Book;
import com.jcommerce.library.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRespository;

    @Override
    public List<Book> findAll() {
        return bookRespository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRespository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRespository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRespository.deleteById(id);
    }
}