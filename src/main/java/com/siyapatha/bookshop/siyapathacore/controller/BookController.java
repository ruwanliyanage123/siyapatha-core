package com.siyapatha.bookshop.siyapathacore.controller;

import com.siyapatha.bookshop.siyapathacore.bean.Book;
import com.siyapatha.bookshop.siyapathacore.service.BookRecordHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookRecordHandler bookRecordHandler = new BookRecordHandler();

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookRecordHandler.saveBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable("isbn") String isbnNumber) {
        Book book = bookRecordHandler.getBookByIsbn(isbnNumber);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Book> getBookByName(@RequestParam("name") String isbnNumber) {
        Book book = bookRecordHandler.getBookByName(isbnNumber);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
}
