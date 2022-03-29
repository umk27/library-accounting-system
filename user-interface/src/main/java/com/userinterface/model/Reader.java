package com.userinterface.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12.02.2022.
 */
public class Reader {

    private long id;

    private String name;

    private List<Book> issedBooks = new ArrayList<>();

    public Reader() {
    }

    public Reader(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getIssedBooks() {
        return issedBooks;
    }

    public void setIssedBooks(List<Book> issedBooks) {
        this.issedBooks = issedBooks;
    }
}
