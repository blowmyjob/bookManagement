package com.bookstore.demo.mapper;

import com.bookstore.demo.entity.book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

    @Select("select * from book")
    List<book>getAll();

    @Select("select * from book where id=#{id}")
    book getBook(int id);

    @Delete("delete from book where id=#{id}")
    void delBook(int id);

    @Insert("insert into book(name,author,price,description,category_id) value(#{name},#{author},#{price},#{description},#{category_id})")
    void addBook(book book);

    @Update("update book set name=#{name},author=#{author},price=#{price},description=#{description},category_id=#{category_id} where id=#{id}")
    void updateBook(book book);
}
