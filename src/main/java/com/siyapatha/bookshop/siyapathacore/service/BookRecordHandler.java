package com.siyapatha.bookshop.siyapathacore.service;

import com.siyapatha.bookshop.siyapathacore.bean.Book;

import java.util.HashMap;
import java.util.Map;

public class BookRecordHandler {
    private Map<String, Book> bookMap = new HashMap<>();

    public void saveBook(Book book){
        bookMap.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn){
        return bookMap.get(isbn);
    }

    public Book getBookByName(String name){
        return new Book("123", "111", "111111", 13.4);
    }
}
