package com.example.demo.strategy;

import com.example.demo.model.Book;

import java.util.Comparator;
import java.util.List;

public interface SortStrategy {
    void sort(List<Book> books);
}

