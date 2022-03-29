package com.accountingservice.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12.02.2022.
 */
@Entity
public class Reader {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    @JoinTable(
            name = "issed_books",
            joinColumns = @JoinColumn(name = "reader_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> issedBooks = new ArrayList<>();

    public Reader() {
    }

    public Reader(String name) {
        this.name = name;
    }

    public Reader(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
