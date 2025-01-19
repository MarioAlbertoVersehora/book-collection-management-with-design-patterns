package com.example.demo.service;

import com.example.demo.factory.BookFactory;
import com.example.demo.model.Book;
import com.example.demo.observer.BookObserver;
import com.example.demo.repository.BookRepository;
import com.example.demo.strategy.SortStrategy;
import com.example.demo.utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookObserver bookObserver;
    private final Logger logger;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.bookObserver = new BookObserver();
        this.logger = Logger.getInstance();
    }

    public Book addBook(Book book) {
        Book savedBook = bookRepository.save(book);
        bookObserver.notifySubscribers("A new book was added: " + book.getTitle());
        logger.log("Book added: " + book.getTitle());
        return savedBook;
    }

    public Book addBookUsingBuilderAndFactory(Book book) {
        Book savedBook = bookRepository.save(BookFactory.createBookWithTitle(book.getTitle()));
        bookObserver.notifySubscribers("A new book was added: " + book.getTitle());
        logger.log("Book added: " + book.getTitle());
        return savedBook;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void sortBooks(List<Book> books, SortStrategy strategy) {
        strategy.sort(books);
    }
}