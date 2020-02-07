package com.example.book;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    private int id;

    @NotBlank
    private String title;

    private int pages;

    private String genre;

    public Book() {
        super();
    }

    public Book(int id, String title, int pages, String genre){
        super();
        this.id = id;
        this.title = title;
        this.pages= pages;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
