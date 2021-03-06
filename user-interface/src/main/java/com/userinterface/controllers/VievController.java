package com.userinterface.controllers;

import com.userinterface.model.Author;
import com.userinterface.model.Book;
import com.userinterface.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by User on 20.02.2022.
 */
@Controller
public class VievController {

    @Autowired
    BookAccountingController controller;

    @GetMapping("/")
    public String mainPage() {
        return "main-page";
    }

    @RequestMapping("/askBookInfo")
    public String askBookInfo(Model model) {

        model.addAttribute("book", new Book());

        return "find-book-info";
    }

    @RequestMapping("/showBookInfo")
    public String showBookInfo(Model model, @ModelAttribute("book") Book book) {
        String title = book.getTitle().trim();
        String authorName = book.getAuthorName().trim();
        if (title.equals("")) {
            String ex = "Введите название книги";
            model.addAttribute("ex", ex);
            return "find-book-info";
        }
        Book book1 = new Book();
        if (!authorName.equals("")) {
            book1 = controller.getBook(authorName, title);
        } else {
            book1 = controller.getBook(title);
        }

        if (book1.getId() == 0) {
            String ex = book1.getTitle();
            model.addAttribute("ex", ex);
            return "find-book-info";
        }
        model.addAttribute("book", book1);

        return "show-book-info";
    }

    @RequestMapping("/askBooksOfAuthor")
    public String askBooksOfAuthor(Model model) {

        model.addAttribute("author", new Author());

        return "find-books-of-author";
    }

    @RequestMapping("/showBooksOfAuthor")
    public String showBooksOfAuthor(Model model, @ModelAttribute("author") Author author) {
        String authorName = author.getName().trim();
        if (authorName.equals("")) {
            model.addAttribute("ex", "Вы не ввели имя автора");
            return "find-books-of-author";
        }
        List<Book> books = controller.getAllBooks(authorName);
        if (books.get(0).getId() == 0) {
            model.addAttribute("ex", books.get(0).getTitle());
            return "find-books-of-author";
        }

        model.addAttribute("booksOfAuthor", books);

        return "show-books-of-author";
    }

    @RequestMapping("/saveNewBook")
    public String saveNewBook(Model model) {

        model.addAttribute("book", new Book());

        return "save-book";
    }

    @RequestMapping("/saveBookQuery")
    public String saveBookQuery(Model model, @ModelAttribute("book") Book book) {
        String title = book.getTitle().trim();
        String authorName = book.getAuthorName().trim();
        if (title.equals("")) {
            model.addAttribute("mes", "Вы не ввели название книги");
            return "save-book";
        }
        if (authorName.equals("")) {
            model.addAttribute("mes", "Вы не ввели имя автора");
            return "save-book";
        }

        if (book.getCountPage() == 0 || book.getNumberOfBooksOnBalance() == 0) {
            String message = "Число страниц и количество книг на балансе не должны быть равны нулю";
            model.addAttribute("mes", message);
            return "save-book";
        }

        Book book1 = new Book(title, book.getCountPage(), book.getNumberOfBooksOnBalance(), book.getNumberOfBooksOnBalance());
        String message = controller.saveNewBook(authorName, book1);
        model.addAttribute("mes", message);

        return "save-book";
    }


    @RequestMapping("/deleteBook")
    public String deleteBook(Model model) {

        model.addAttribute("book", new Book());

        return "delete-book";
    }

    @RequestMapping("/deleteBookQuery")
    public String deleteBookQuery(Model model, @ModelAttribute("book") Book book) {
        String title = book.getTitle().trim();
        String authorName = book.getAuthorName().trim();
        if (title.equals("")) {
            model.addAttribute("mes", "Вы не ввели название книги");
            return "delete-book";
        }
        if (authorName.equals("")) {
            model.addAttribute("mes", "Вы не ввели имя автора");
            return "delete-book";
        }


        String message = controller.deleteBook(authorName, title);
        model.addAttribute("mes", message);

        return "delete-book";
    }

    @RequestMapping("/saveReader")
    public String saveReader(Model model) {

        model.addAttribute("reader", new Reader());

        return "save-reader";
    }

    @RequestMapping("/saveReaderQuery")
    public String deleteBookQuery(Model model, @ModelAttribute("reader") Reader reader) {
        String readerName = reader.getName().trim();
        if (readerName.equals("")) {
            model.addAttribute("mes", "Вы не ввели имя читателя");
            return "save-reader";
        }

        String message = controller.saveReader(readerName);
        model.addAttribute("mes", message);

        return "save-reader";
    }

    @RequestMapping("/takeBook")
    public String takeBook(Model model) {

        model.addAttribute("book", new Book());

        return "take-book";
    }

    @RequestMapping("/takeBookQuery")
    public String takeBookInfo(Model model, @ModelAttribute("book") Book book) {
        String title = book.getTitle().trim();
        String authorName = book.getAuthorName().trim();
        String readerName = book.getReaderName().trim();
        if (title.equals("")) {
            model.addAttribute("mes", "Вы не ввели название книги");
            return "take-book";
        }
        if (authorName.equals("")) {
            model.addAttribute("mes", "Вы не ввели имя автора");
            return "take-book";
        }
        if (readerName.equals("")) {
            model.addAttribute("mes", "Вы не ввели имя читателя");
            return "take-book";
        }

        String message = controller.takeBook(readerName, authorName, title);
        model.addAttribute("mes", message);

        return "take-book";
    }

    @RequestMapping("/returnBook")
    public String returnBook(Model model) {

        model.addAttribute("book", new Book());

        return "return-book";
    }

    @RequestMapping("/returnBookQuery")
    public String returnBookQuery(Model model, @ModelAttribute("book") Book book) {
        String title = book.getTitle().trim();
        String authorName = book.getAuthorName().trim();
        String readerName = book.getReaderName().trim();
        if (title.equals("")) {
            model.addAttribute("mes", "Вы не ввели название книги");
            return "return-book";
        }
        if (authorName.equals("")) {
            model.addAttribute("mes", "Вы не ввели имя автора");
            return "return-book";
        }
        if (readerName.equals("")) {
            model.addAttribute("mes", "Вы не ввели имя читателя");
            return "return-book";
        }

        String message = controller.returnBook(readerName, authorName, title);
        model.addAttribute("mes", message);

        return "return-book";
    }

    @RequestMapping("/deleteReader")
    public String deleteReader(Model model) {

        model.addAttribute("reader", new Reader());

        return "delete-reader";
    }

    @RequestMapping("/deleteReaderQuery")
    public String deleteReaderQuery(Model model, @ModelAttribute("reader") Reader reader) {
        String readerName = reader.getName().trim();
        if (readerName.equals("")) {
            model.addAttribute("mes", "Вы не ввели имя читателя");
            return "delete-reader";
        }

        String message = controller.deleteReader(readerName);
        model.addAttribute("mes", message);

        return "delete-reader";
    }

    @RequestMapping("/askBooksOfReader")
    public String askBooksOfReader(Model model) {
        model.addAttribute("reader", new Reader());

        return "find-books-of-reader";
    }

    @RequestMapping("/showBooksOfReader")
    public String showBooksOfReader(Model model, @ModelAttribute("reader") Reader reader) {
        String readerName = reader.getName().trim();
        if (readerName.equals("")) {
            model.addAttribute("mes", "Вы не ввели имя читателя");
            return "find-books-of-reader";
        }

        List<Book> books = controller.getAllBooksOfReader(readerName);
        if (books.get(0).getId() == 0) {
            model.addAttribute("mes", books.get(0).getTitle());
            return "find-books-of-reader";
        }

        model.addAttribute("booksOfReader", books);

        return "show-books-of-reader";
    }

    @RequestMapping("/askReadersOfBook")
    public String askReadersOfBook(Model model) {
        model.addAttribute("book", new Book());

        return "find-readers-of-book";
    }

    @RequestMapping("/showReadersOfBook")
    public String showReadersOfBook(Model model, @ModelAttribute("book") Book book) {
        String title = book.getTitle().trim();
        String authorName = book.getAuthorName().trim();
        if (title.equals("")) {
            model.addAttribute("mes", "Вы не ввели название книги");
            return "find-readers-of-book";
        }
        if (authorName.equals("")) {
            model.addAttribute("mes", "Вы не ввели имя автора");
            return "find-readers-of-book";
        }

        List<Reader> readers = controller.getAllReadersOfBook(authorName, title);
        if (readers.get(0).getId() == 0) {
            model.addAttribute("mes", readers.get(0).getName());
            return "find-readers-of-book";
        }

        model.addAttribute("readersOfBook", readers);

        return "show-readers-of-book";
    }
}
