package com.example.book;

public class BookNotFoundException extends Exception {

    private int id;

    public BookNotFoundException(int id) {
        super(String.format("Book Not Found : %s", id));
    }
}
