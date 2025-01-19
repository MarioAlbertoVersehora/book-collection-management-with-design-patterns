package com.example.demo.factory;

import com.example.demo.model.Book;

public class BookFactory {
    public static Book createBookWithGenre(String genre) {
        return new Book.Builder()
                .title("Default Title")
                .author("Default Author")
                .genre(genre)
                .pages(100)
                .build();
    }
    public static Book createBookWithTitle(String title) {
        return new Book.Builder()
                .title(title)
                .author("Default Author")
                .genre("Default Genre")
                .pages(100)
                .build();
    }
    public static Book createBookWithPages(int pages) {
        return new Book.Builder()
                .title("Default Title")
                .author("Default Author")
                .genre("Default Genre")
                .pages(pages)
                .build();
    }
    public static Book createBookWithTitleAndAuthorPages(String title, String author) {
        return new Book.Builder()
                .title(title)
                .author(author)
                .genre("Default Genre")
                .pages(100)
                .build();
    }
}