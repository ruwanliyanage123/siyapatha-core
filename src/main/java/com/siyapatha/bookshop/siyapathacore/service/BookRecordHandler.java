package com.siyapatha.bookshop.siyapathacore.service;

import com.siyapatha.bookshop.siyapathacore.bean.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRecordHandler {
    private Map<Integer, Book> bookMap = new HashMap<>();

    public void saveBook(Book book){
        bookMap.put(book.getIsbn(), book);
        System.out.println("Map size :" +bookMap.size());
    }

    public Book getBookByIsbn(int isbn){
        return bookMap.get(isbn);
    }

    public Book getBookByName(String name){
        return new Book(-1, "111", "111111", 13.4);
    }

    public List<Book> getAllBooks(){
        return new ArrayList<>(bookMap.values());
    }
}
