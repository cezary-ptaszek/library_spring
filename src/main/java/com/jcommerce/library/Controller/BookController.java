package com.jcommerce.library.Controller;

import com.jcommerce.library.Entity.Book;
import com.jcommerce.library.Services.BookService;
import com.jcommerce.library.Services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
class BookController {

    private BookService bookService;
    private ReaderService readerService;

    @Autowired
    public BookController(BookService bookService, ReaderService readerService){
        this.bookService = bookService;
        this.readerService = readerService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Optional<Book> book = bookService.findById(id);
        return book.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
        if (!bookService.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
           return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
        }
    }

    @PutMapping("{readerId}/borrow/{bookId}")
    public ResponseEntity borrowBook(@PathVariable Long bookId, @PathVariable Long readerId) {
        if(!bookService.findById(bookId).isPresent() || !readerService.findById(readerId).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some parameter does not exist.");
        }
        else {
            Book book = bookService.findById(bookId).get();

            if (book.getReaderId() != null) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Too late! Please wait until it is given back.");
            } else {
                book.setReaderId(readerId);
                bookService.save(book);
                return ResponseEntity.status(HttpStatus.CREATED).body("Well done, you borrowed the book.");
            }
        }
    }


    @PutMapping("{readerId}/give-back/{bookId}")
    public ResponseEntity giveBackBook(@PathVariable Long bookId, @PathVariable Long readerId) {
        if(!bookService.findById(bookId).isPresent() || !readerService.findById(bookId).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some parameter does not exist.");
        }
        else {
            Book book = bookService.findById(bookId).get();

            if (book.getReaderId() != null && book.getReaderId().equals(readerId)) {
                book.setReaderId(null);
                bookService.save(book);
                return ResponseEntity.status(HttpStatus.CREATED).body("Well done, you gave the book back.");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is nothing to do.");
            }
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!bookService.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            bookService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Book deleted.");
        }
    }
}