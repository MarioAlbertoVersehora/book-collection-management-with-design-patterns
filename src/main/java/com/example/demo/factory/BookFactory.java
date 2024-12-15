package com.example.demo.factory;

import com.example.demo.model.Book;

public class BookFactory {
    public static Book createBook(String genre) {
        return new Book.Builder()
                .title("Default Title")
                .author("Unknown")
                .genre(genre)
                .pages(100)
                .build();
    }
}