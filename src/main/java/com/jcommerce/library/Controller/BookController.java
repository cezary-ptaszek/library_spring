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
class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        ResponseEntity response;

        Optional<Book> book = bookService.findById(id);
        if (!book.isPresent()) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            response = ResponseEntity.status(HttpStatus.OK).body(book.get());
        }
        return response;
    }


    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
    }


    @PostMapping("/update/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @Valid @RequestBody Book book) {
        ResponseEntity response;

        if (!bookService.findById(id).isPresent()) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            response = ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
        }
        return response;
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ResponseEntity response;

        if (!bookService.findById(id).isPresent()) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            bookService.deleteById(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Deleted.");
        }

        return response;
    }
}