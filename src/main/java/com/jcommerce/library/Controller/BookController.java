package com.jcommerce.library.Controller;

import com.jcommerce.library.Entity.Book;
import com.jcommerce.library.Services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Optional<Book> book = bookService.findById(id);
        if (!book.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book.get());
    }


    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
    }


    @PostMapping("/update/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @Valid @RequestBody Book book) {
        if (!bookService.findById(id).isPresent()) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!bookService.findById(id).isPresent()) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        bookService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted.");
    }
}