package com.userinterface.restClient;

import com.userinterface.model.Author;
import com.userinterface.model.Book;
import com.userinterface.model.Reader;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 19.02.2022.
 */
//@FeignClient(name = "BOOK-ACCOUNTING-SERVICE")
@FeignClient(name = "book-accounting-service", url = "${BOOK_ACCOUNTING_URI:http://localhost}:8000")
public interface BookAccountingClient {

    @GetMapping("/getAuthor/author/{authorName}")
    public Author getAuthor(@PathVariable("authorName") String authorName);

    @GetMapping("/getBook/author/{authorName}/title/{title}")
    public Book getBook(@PathVariable("authorName") String authorName, @PathVariable("title") String title);

    @GetMapping("/getBook/title/{title}")
    public Book getBook(@PathVariable("title") String title);

    @GetMapping("/getAllBooks/author/{authorName}")
    public List<Book> getAllBooks(@PathVariable("authorName") String authorName);

    @PostMapping("/saveNewBook/author/{authorName}")
    public String saveNewBook(@PathVariable("authorName") String authorName, @RequestBody Book book);

    @DeleteMapping("/deleteBook/author/{authorName}/title/{title}")
    public String deleteBook(@PathVariable("authorName") String authorName, @PathVariable("title") String title);

    @PostMapping("/saveReader/reader/{readerName}")
    public String saveReader(@PathVariable("readerName") String readerName);

    @PutMapping("/takeBook/reader/{readerName}/author/{authorName}/title/{title}")
    public String takeBook(@PathVariable("readerName") String readerName, @PathVariable("authorName") String authorName, @PathVariable("title") String title);

    @PutMapping("/returnBook/reader/{readerName}/author/{authorName}/title/{title}")
    public String returnBook(@PathVariable("readerName") String readerName, @PathVariable("authorName") String authorName, @PathVariable("title") String title);

    @DeleteMapping("/deleteReader/reader/{readerName}")
    public String deleteReader(@PathVariable("readerName") String readerName);

    @GetMapping("/getAllBooksOfReader/reader/{readerName}")
    public List<Book> getAllBooksOfReader(@PathVariable("readerName") String readerName);

    @GetMapping("/getAllReadersOfBook/author/{authorName}/title/{title}")
    public List<Reader> getAllReadersOfBook(@PathVariable("authorName") String authorName, @PathVariable("title") String title);
}
