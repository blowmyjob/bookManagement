package com.bookstore.demo.service;

import com.bookstore.demo.entity.category;

import java.util.List;

public interface CategoryService {
    void addCategory(category category);

    void delCategory(int id);

    List<category>getAll();

    category queryCategoryById(int id);

    void updateById(int id,String name);
}
