package com.hachiko.redisdemo.controller;


import com.hachiko.redisdemo.model.Books;
import com.hachiko.redisdemo.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("")
    public ResponseEntity<List<Books>> getAllBooks() {
        return ResponseEntity.ok(booksService.getAllBooks());
    }

    @PostMapping("")
    public ResponseEntity<Books> createBooks(@RequestBody Books books) {
        return ResponseEntity.ok(booksService.createBooks(books));
    }






}
