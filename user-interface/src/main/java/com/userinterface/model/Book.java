package com.userinterface.model;

import com.userinterface.model.Author;
import com.userinterface.model.Reader;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05.02.2022.
 */
public class Book {

    private long id;

    private String title;

    private int countPage;

    private int numberOfBooksAvailable;

    private int numberOfBooksOnBalance;

    private Author author;

    private String authorName;

    private String readerName;


    List<Reader> readers = new ArrayList<>();

    public Book() {
    }

    public Book(String title) {
        this.title = title;

    }

    public Book(String title, int countPage, int numberOfBooksOnBalance) {
        this.title = title;
        this.countPage = countPage;
        this.numberOfBooksOnBalance = numberOfBooksOnBalance;
    }

    public Book(String title, int countPage, int numberOfBooksAvailable, int numberOfBooksOnBalance) {
        this.title = title;
        this.countPage = countPage;
        this.numberOfBooksAvailable = numberOfBooksAvailable;
        this.numberOfBooksOnBalance = numberOfBooksOnBalance;
    }

    public Book(long id, String title, int countPage, int numberOfBooksAvailable, int numberOfBooksOnBalance, Author author) {
        this.id = id;
        this.title = title;
        this.countPage = countPage;
        this.numberOfBooksAvailable = numberOfBooksAvailable;
        this.numberOfBooksOnBalance = numberOfBooksOnBalance;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getNumberOfBooksAvailable() {
        return numberOfBooksAvailable;
    }

    public void setNumberOfBooksAvailable(int numberOfBooksAvailable) {
        this.numberOfBooksAvailable = numberOfBooksAvailable;
    }

    public int getNumberOfBooksOnBalance() {
        return numberOfBooksOnBalance;
    }

    public void setNumberOfBooksOnBalance(int numberOfBooksOnBalance) {
        this.numberOfBooksOnBalance = numberOfBooksOnBalance;
    }

    public Author getAuthor() {
        return author;
    }

  /*  public String getAuthor() {
        return author.getName();
    }*/

    public void setAuthor(Author author) {
        this.author = author;
    }

   /* public void setAuthor(String authorName) {
        this.author = new Author(authorName);
    }*/

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", countPage=" + countPage +
                ", numberOfBooksAvailable=" + numberOfBooksAvailable +
                ", numberOfBooksOnBalance=" + numberOfBooksOnBalance +
                ", author=" + author +
                '}';
    }
}
