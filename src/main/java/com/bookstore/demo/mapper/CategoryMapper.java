package com.bookstore.demo.mapper;

import com.bookstore.demo.entity.category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CategoryMapper {
    @Select("select * from category")
    @Results({
            @Result(property = "id" ,column = "id"),
            @Result(property = "name",  column = "name")
    })
    List<category>getAll();

    @Select("select * from category where id=#{id}")
    @Results({
            @Result(property = "id" ,column = "id"),
            @Result(property = "name",  column = "name")
    })
    category getOne(int id);

    @Select("delete from category where id=#{id}")
    void delete(int id);

    @Update("update category set name=#{name} where id=#{id}")
    void update(int id,String name);

    @Insert("insert into category(name) value(#{name})")
    void insert(category category);
}
