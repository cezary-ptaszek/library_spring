package com.jcommerce.library.Controller;

import com.jcommerce.library.Entity.Reader;
import com.jcommerce.library.Services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reader")
class ReaderController {

    private ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService){
        this.readerService = readerService;
    }


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
    public ResponseEntity create(@RequestBody Reader reader) {
        return ResponseEntity.status(HttpStatus.CREATED).body(readerService.save(reader));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Reader reader) {
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
            return ResponseEntity.status(HttpStatus.OK).body("Reader deleted.");
        }
    }
}