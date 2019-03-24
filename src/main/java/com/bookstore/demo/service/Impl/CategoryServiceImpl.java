package com.bookstore.demo.service.Impl;

import com.bookstore.demo.entity.category;
import com.bookstore.demo.mapper.CategoryMapper;
import com.bookstore.demo.repository.CategoryRepository;
import com.bookstore.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void addCategory(category category) { categoryMapper.insert(category); }

    @Override
    public void delCategory(int id) { categoryMapper.delete(id); }

    @Override
    public List<category> getAll() { return categoryMapper.getAll(); }

    @Override
    public category queryCategoryById(int id) {
        return categoryMapper.getOne(id);
    }

    @Override
    public void updateById(int id,String name){
        categoryMapper.update(id,name);
    }
}
