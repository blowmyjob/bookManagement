package com.bookstore.demo.service;

import com.bookstore.demo.entity.*;

import java.util.List;

public interface BookService {
    void addBook(book book);

    void delBook(int id);

    List<book> getAllBook();

    book getBook(int id);

    void updateBook(book book);
}
