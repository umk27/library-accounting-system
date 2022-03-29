package com.userinterface.controllers;

import com.userinterface.model.Author;
import com.userinterface.model.Book;
import com.userinterface.model.Reader;
import com.userinterface.restClient.BookAccountingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 19.02.2022.
 */
@RestController
public class BookAccountingController {

    @Autowired
    BookAccountingClient client;

    @GetMapping("/getBook/author/{authorName}/title/{title}")
    public Book getBook(@PathVariable String authorName, @PathVariable String title) {
        Book book = client.getBook(authorName, title);
        Author author = new Author(book.getAuthor().getId(), book.getAuthor().getName());
        return new Book(book.getId(), book.getTitle(), book.getCountPage(), book.getNumberOfBooksAvailable(), book.getNumberOfBooksOnBalance(), author);
    }

    @GetMapping("/getBook/title/{title}")
    public Book getBook(@PathVariable String title) {
        Book book = client.getBook(title);
        Author author = new Author(book.getAuthor().getId(), book.getAuthor().getName());
        return new Book(book.getId(), book.getTitle(), book.getCountPage(), book.getNumberOfBooksAvailable(), book.getNumberOfBooksOnBalance(), author);
    }

    @GetMapping("/getAllBooks/author/{authorName}")
    public List<Book> getAllBooks(@PathVariable String authorName) {
        List<Book> books = client.getAllBooks(authorName);

        return books;
    }

    @PostMapping("/saveNewBook/author/{authorName}")
    public String saveNewBook(@PathVariable String authorName, @RequestBody Book book) {
        return client.saveNewBook(authorName, book);
    }

    @DeleteMapping("/deleteBook/author/{authorName}/title/{title}")
    public String deleteBook(@PathVariable String authorName, @PathVariable String title) {
        String message = client.deleteBook(authorName, title);
        return message;
    }

    @PostMapping("/saveReader/reader/{readerName}")
    public String saveReader(@PathVariable String readerName) {
        String message = client.saveReader(readerName);
        return message;
    }

    @PutMapping("/takeBook/reader/{readerName}/author/{authorName}/title/{title}")
    public String takeBook(@PathVariable String readerName, @PathVariable String authorName, @PathVariable String title) {
        String message = client.takeBook(readerName, authorName, title);
        return message;
    }

    @PutMapping("/returnBook/reader/{readerName}/author/{authorName}/title/{title}")
    public String returnBook(@PathVariable String readerName, @PathVariable String authorName, @PathVariable String title) {
        String message = client.returnBook(readerName, authorName, title);
        return message;
    }

    @DeleteMapping("/deleteReader/reader/{readerName}")
    public String deleteReader(@PathVariable String readerName) {
        String message = client.deleteReader(readerName);
        return message;
    }

    @GetMapping("/getAllBooksOfReader/reader/{readerName}")
    public List<Book> getAllBooksOfReader(@PathVariable("readerName") String readerName) {
        List<Book> books = client.getAllBooksOfReader(readerName);
        return books;
    }

    @GetMapping("/getAllReadersOfBook/author/{authorName}/title/{title}")
    public List<Reader> getAllReadersOfBook(@PathVariable String authorName, @PathVariable String title) {
        List<Reader> readers = client.getAllReadersOfBook(authorName, title);
        return readers;
    }
}
