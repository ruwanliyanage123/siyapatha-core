package com.siyapatha.bookshop.siyapathacore.controller;

import com.siyapatha.bookshop.siyapathacore.bean.Book;
import com.siyapatha.bookshop.siyapathacore.service.BookRecordHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookRecordHandler bookRecordHandler = new BookRecordHandler();

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> createBook(@RequestHeader("Authorization") String apiKey, @RequestBody Book book) {
        if(apiKey.equals("ruwan")) {
            bookRecordHandler.saveBook(book);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }

    @RequestMapping(value = {"/findBookByIsbn/{isbn}"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> findBookByIsbn(@PathVariable("isbn") int isbnNumber) {
        Book book = bookRecordHandler.getBookByIsbn(isbnNumber);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/findBookByName", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> findBookByName(@RequestParam("name") String isbnNumber) {
        Book book = bookRecordHandler.getBookByName(isbnNumber);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRecordHandler.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.CREATED);
    }
}
