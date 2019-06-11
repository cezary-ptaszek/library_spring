package com.jcommerce.library.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
class MainController {

    @GetMapping
    public ResponseEntity mainView() {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome in the library!");
    }
}