package com.accountingservice.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05.02.2022.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "count_page")
    private int countPage;

    @Column(name = "number_of_books_available")
    private int numberOfBooksAvailable;

    @Column(name = "number_of_books_on_balance")
    private int numberOfBooksOnBalance;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(mappedBy = "issedBooks", cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    List<Reader> readers = new ArrayList<>();

    public Book() {
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;

    }

    public Book(String title, int countPage, int numberOfBooksOnBalance) {
        this.title = title;
        this.countPage = countPage;
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

    public void setAuthor(Author author) {
        this.author = author;
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
