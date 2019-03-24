package com.bookstore.demo.service.Impl;

import com.bookstore.demo.entity.book;
import com.bookstore.demo.mapper.BookMapper;
import com.bookstore.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public void addBook(book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void delBook(int id) {
        bookMapper.delBook(id);
    }


    @Override
    public List<book> getAllBook() {
        return bookMapper.getAll();
    }

    @Override
    public book getBook(int id) {
        return bookMapper.getBook(id);
    }

    @Override
    public void updateBook(book book) {
        bookMapper.updateBook(book);
    }
}
