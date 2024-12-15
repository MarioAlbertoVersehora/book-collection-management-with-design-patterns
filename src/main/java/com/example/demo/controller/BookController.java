package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.strategy.SortByPages;
import com.example.demo.strategy.SortByTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/sort/title")
    public List<Book> sortByTitle() {
        List<Book> books = bookService.getAllBooks();
        bookService.sortBooks(books, new SortByTitle());
        return books;
    }

    @GetMapping("/sort/pages")
    public List<Book> sortByPages() {
        List<Book> books = bookService.getAllBooks();
        bookService.sortBooks(books, new SortByPages());
        return books;
    }
}
