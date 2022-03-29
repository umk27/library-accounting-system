package com.userinterface.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05.02.2022.
 */
public class Author {

    private long id;

    private String name;

    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(String name) {
        this.name = name;
    }

    public long getId() {
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        if (books != null) {
            for (Book b : books) {
                b.setAuthor(this);
            }
        }
        this.books = books;
    }


}
