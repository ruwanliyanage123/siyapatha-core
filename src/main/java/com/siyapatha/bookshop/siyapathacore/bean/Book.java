package com.siyapatha.bookshop.siyapathacore.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int isbn;
    private String name;
    private String author;
    private double price;
}
