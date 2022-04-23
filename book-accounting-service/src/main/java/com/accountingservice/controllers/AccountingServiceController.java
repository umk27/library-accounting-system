package com.accountingservice.controllers;

import com.accountingservice.entities.Author;
import com.accountingservice.entities.Book;
import com.accountingservice.entities.Reader;
import com.accountingservice.repositories.AuthorRepository;
import com.accountingservice.repositories.BookRepository;
import com.accountingservice.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by User on 05.02.2022.
 */
@RestController
public class AccountingServiceController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    private Author getAuthor(@PathVariable String authorName) {
        Optional<Author> optional = authorRepository.findByName(authorName);
        if (!optional.isPresent()) {
            return new Author("Автор " + authorName + " не найден");
        }
        return optional.get();
    }

    /*@GetMapping("/getAuthor/author/{authorName}")
    public Author getAuthorInfo(@PathVariable String authorName) {
        Author author = getAuthor(authorName);
        List<Book> books = new ArrayList<>();
        for (Book b : author.getBooks()) {
            Book book = new Book(b.getId(),b.getTitle(),b.getCountPage(),b.getNumberOfBooksAvailable(),b.getNumberOfBooksOnBalance(),
                    new Author(b.getAuthor().getName()));

        }
        return new Author(author.getId(), author.getName(), books);
    }*/

    private Book getBook(String authorName, String title) {
        Book book = null;
        Author author = getAuthor(authorName);
        if (author.getName().equals("Автор " + authorName + " не найден")) {
            return new Book(author.getName(), new Author("нет"));
        }
        for (Book b : author.getBooks()) {
            if (b.getTitle().equals(title)) {
                book = b;
            }
        }
        if (book == null) {
            return new Book("Книга " + title + " автора " + authorName + " не найдена", new Author("нет"));
        }
        return book;

    }

    @GetMapping("/getBook/author/{authorName}/title/{title}")
    public Book getBookInfo(@PathVariable String authorName, @PathVariable String title) {
        Book book = getBook(authorName, title);
        Author author = new Author(book.getAuthor().getId(), book.getAuthor().getName());
        return new Book(book.getId(), book.getTitle(), book.getCountPage(), book.getNumberOfBooksAvailable(), book.getNumberOfBooksOnBalance(), author);
    }

    private Book getBook(String title) {
        Optional<Book> optional = bookRepository.findByTitle(title);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return new Book("Книга " + title + " не найдена", new Author("нет"));
        }

    }

    @GetMapping("/getBook/title/{title}")
    public Book getBookInfo(@PathVariable String title) {
        Book book = getBook(title);
        Author author = new Author(book.getAuthor().getId(), book.getAuthor().getName());
        return new Book(book.getId(), book.getTitle(), book.getCountPage(), book.getNumberOfBooksAvailable(), book.getNumberOfBooksOnBalance(), author);
    }

    @GetMapping("/getAllBooks/author/{authorName}")
    public List<Book> getAllBooks(@PathVariable String authorName) {
        Author author = getAuthor(authorName);
        List<Book> books = new ArrayList<>();
        if (author.getName().equals("Автор " + authorName + " не найден")) {
            books.add(new Book(author.getName(), new Author("нет")));
            return books;
        }
        books = author.getBooks();
        List<Book> books1 = new ArrayList<>();
        for (Book b : books) {
            books1.add(new Book(b.getId(), b.getTitle(), b.getCountPage(), b.getNumberOfBooksAvailable(), b.getNumberOfBooksOnBalance(),
                    new Author(b.getAuthor().getName())));
        }
        return books1;
    }


    @PostMapping("/saveNewBook/author/{authorName}")
    public String saveNewBook(@PathVariable String authorName, @RequestBody Book book) {

        if (getBook(authorName, book.getTitle()).getTitle().equals(book.getTitle())) {
            return "Книга " + book.getTitle() + " уже есть в базе данных";
        }
        Author author = getAuthor(authorName);
        if (author.getName().equals("Автор " + authorName + " не найден")) {
            author = new Author(authorName);
        }
        book.setNumberOfBooksAvailable(book.getNumberOfBooksOnBalance());


        List<Book> books = author.getBooks();
        books.add(book);
        author.setBooks(books);
        authorRepository.save(author);
        return "Книга " + book.getTitle() + " сохранена";


    }

    @DeleteMapping("/deleteBook/author/{authorName}/title/{title}")
    public String deleteBook(@PathVariable String authorName, @PathVariable String title) {

        Book book1 = getBook(authorName, title);
        if (book1.getTitle().equals("Автор " + authorName + " не найден") || (book1.getTitle().equals("Книга " + title + " автора " + authorName + " не найдена"))) {
            return book1.getTitle();
        }

        if (book1.getReaders().size() != 0) {
            return "Есть книги, выданные читателям";
        }

        Author author = book1.getAuthor();

        List<Book> books = author.getBooks();

        if (books.size() == 1 && books.get(0).getTitle().equals(title)) {
            authorRepository.delete(author);
            return "Автор " + authorName + " и книга " + title + " удалены";
        }
        books.remove(book1);

        author.setBooks(books);
        authorRepository.save(author);

        return "Книга " + title + " удалена";

    }

    @PostMapping("/saveReader/reader/{readerName}")
    public String saveReader(@PathVariable String readerName) {
        if (getReader(readerName).getName().equals(readerName)) {
            return "Читатель " + readerName + " уже есть в базе";
        }
        readerRepository.save(new Reader(readerName));
        return "Читатель " + readerName + " добавлен в базу";
    }

    private Reader getReader(@PathVariable String readerName) {
        Optional<Reader> optional = readerRepository.findByName(readerName);
        if (!optional.isPresent()) {
            return new Reader("Читатель " + readerName + " не найден");
        }
        return optional.get();
    }

    @PutMapping("/takeBook/reader/{readerName}/author/{authorName}/title/{title}")
    public String takeBook(@PathVariable String readerName, @PathVariable String authorName, @PathVariable String title) {
        Book book = getBook(authorName, title);
        if (book.getTitle().equals("Автор " + authorName + " не найден") || (book.getTitle().equals("Книга " + title + " автора " + authorName + " не найдена"))) {
            return book.getTitle();
        }
        Author author = book.getAuthor();

        if (book.getNumberOfBooksAvailable() > 0) {

            book.setNumberOfBooksAvailable(book.getNumberOfBooksAvailable() - 1);
            Book book1 = new Book();
            List<Book> books = author.getBooks();
            for (Book b : books) {
                if (b.getTitle().equals(title)) {
                    book1 = b;


                }
            }
            if (books.contains(book1)) {
                books.remove(book1);
                books.add(book);
            }


            Reader reader = getReader(readerName);
            if (reader.getName().equals("Читатель " + readerName + " не найден")) {
                return reader.getName();
            }
            List<Book> issedBooks = reader.getIssedBooks();
            if (issedBooks.contains(book)) {
                return "Читатель " + readerName + " уже взял книгу " + title;
            }
            issedBooks.add(book);
            readerRepository.save(reader);

            author.setBooks(books);
            authorRepository.save(author);


            return "Выдана книга " + title + " читателю " + readerName + ", книг в наличии "
                    + book.getNumberOfBooksAvailable() + ", книг на балансе " + book.getNumberOfBooksOnBalance();

        } else {
            return "Нет книг " + title + " в наличии";
        }

    }

    @PutMapping("/returnBook/reader/{readerName}/author/{authorName}/title/{title}")
    public String returnBook(@PathVariable String readerName, @PathVariable String authorName, @PathVariable String title) {
        Book book = getBook(authorName, title);
        if (book.getTitle().equals("Автор " + authorName + " не найден") || (book.getTitle().equals("Книга " + title + " автора " + authorName + " не найдена"))) {
            return book.getTitle();
        }
        Author author = book.getAuthor();


        book.setNumberOfBooksAvailable(book.getNumberOfBooksAvailable() + 1);
        List<Book> books = author.getBooks();
        Book book1 = new Book();
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                book1 = b;

            }
        }
        if (books.contains(book1)) {
            books.remove(book1);
            books.add(book);
        }


        Reader reader = getReader(readerName);
        if (reader.getName().equals("Читатель " + readerName + " не найден")) {
            return reader.getName();
        }
        List<Book> issedBooks = reader.getIssedBooks();
        if (!issedBooks.contains(book)) {
            return "Читатель " + readerName + " не брал книгу " + title;
        }
        issedBooks.remove(book);
        readerRepository.save(reader);

        author.setBooks(books);
        authorRepository.save(author);


        return "Читатель " + readerName + " вернул книгу " + title + ", книг в наличии "
                + book.getNumberOfBooksAvailable() + ", книг на балансе " + book.getNumberOfBooksOnBalance();


    }

    @DeleteMapping("/deleteReader/reader/{readerName}")
    public String deleteReader(@PathVariable String readerName) {
        Reader reader = getReader(readerName);
        if (reader.getName().equals("Читатель " + readerName + " не найден")) {
            return reader.getName();
        }
        if (reader.getIssedBooks().size() == 0) {
            readerRepository.delete(reader);

        } else {
            return "Читатель " + readerName + " имеет несданные книги";
        }

        return "Читатель " + readerName + " удален из базы";
    }


    @GetMapping("/getAllBooksOfReader/reader/{readerName}")
    public List<Book> getAllBooksOfReader(@PathVariable String readerName) {
        Reader reader = getReader(readerName);
        if (reader.getName().equals("Читатель " + readerName + " не найден")) {
            List<Book> books = new ArrayList<>();
            Book book = new Book(reader.getName(), new Author("нет"));
            books.add(book);
            return books;
        }
        List<Book> books = reader.getIssedBooks();
        List<Book> books1 = new ArrayList<>();
        for (Book b : books) {
            books1.add(new Book(b.getId(), b.getTitle(), b.getCountPage(), b.getNumberOfBooksAvailable(), b.getNumberOfBooksOnBalance(),
                    new Author(b.getAuthor().getName())));
        }
        return books1;
    }

    @GetMapping("/getAllReadersOfBook/author/{authorName}/title/{title}")
    public List<Reader> getAllReadersOfBook(@PathVariable String authorName, @PathVariable String title) {
        Book book = getBook(authorName, title);
        if (book.getTitle().equals("Автор " + authorName + " не найден") || (book.getTitle().equals("Книга " + title + " автора " + authorName + " не найдена"))) {
            List<Reader> readers = new ArrayList<>();
            Reader reader = new Reader(book.getTitle());
            readers.add(reader);
            return readers;
        }
        if (book.getNumberOfBooksAvailable() == book.getNumberOfBooksOnBalance()) {
            List<Reader> readers = new ArrayList<>();
            Reader reader = new Reader("Все книги в библиотеке в количестве " + book.getNumberOfBooksOnBalance());
            readers.add(reader);
            return readers;
        }
        List<Reader> readers = book.getReaders();
        List<Reader> readers1 = new ArrayList<>();
        for (Reader r : readers) {
            readers1.add(new Reader(r.getId(), r.getName()));
        }
        return readers1;
    }
}
