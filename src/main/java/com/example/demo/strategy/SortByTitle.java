package com.example.demo.strategy;

import com.example.demo.model.Book;

import java.util.Comparator;
import java.util.List;

public class SortByTitle implements SortStrategy {
    @Override
    public void sort(List<Book> books) {
        books.sort(Comparator.comparing(Book::getTitle));
    }
}
