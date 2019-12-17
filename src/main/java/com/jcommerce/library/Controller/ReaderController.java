package com.jcommerce.library.Controller;

import com.jcommerce.library.Entity.Reader;
import com.jcommerce.library.Entity.Book;
import com.jcommerce.library.Services.BookService;
import com.jcommerce.library.Services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reader")
class ReaderController {

    @Autowired
    private ReaderService readerService;
    @Autowired
    private BookService bookService;


    @GetMapping("/all")
    public ResponseEntity<List<Reader>> getAllReaders() {
        return ResponseEntity.status(HttpStatus.OK).body(readerService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reader> findById(@PathVariable Long id) {
        Optional<Reader> reader = readerService.findById(id);
        return reader.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }


    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody Reader reader) {
        return ResponseEntity.status(HttpStatus.CREATED).body(readerService.save(reader));
    }


    @PostMapping("{readerId}/borrow/book/{bookId}")
    public ResponseEntity borrowBook(@PathVariable Long bookId, @PathVariable Long readerId) {
        if(!bookService.findById(bookId).isPresent() || !readerService.findById(readerId).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            Book book = bookService.findById(bookId).get();

            if (book.getReaderId() != null) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Too late! Please wait until it is given back.");
            } else {
                book.setReaderId(readerService.findById(readerId).orElseThrow(
                        () -> new ResourceAccessException("Reader not found with id: " + readerId)));
                bookService.save(book);
                return ResponseEntity.status(HttpStatus.CREATED).body("Well done, you borrowed the book.");
            }
        }
    }


    @PostMapping("{readerId}/giveBack/book/{bookId}")
    public ResponseEntity giveBackBook(@PathVariable Long bookId, @PathVariable Long readerId) {
        if(!bookService.findById(bookId).isPresent() || !readerService.findById(bookId).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            Book book = bookService.findById(bookId).get();

            if (book.getReaderId() != null && book.getReaderId().equals((Object)readerId)) {
                book.setReaderId(null);
                bookService.save(book);
                return ResponseEntity.status(HttpStatus.CREATED).body("Well done, you gave the book back.");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("There is nothing to do.");
            }
        }
    }


    @PostMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody Reader reader) {
        if (readerService.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(readerService.save(reader));
        }
        else  {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!readerService.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            readerService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted.");
        }
    }
}