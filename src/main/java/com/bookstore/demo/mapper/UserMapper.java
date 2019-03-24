package com.bookstore.demo.mapper;

import com.bookstore.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "id" ,column = "id"),
            @Result(property = "username",  column = "username"),
            @Result(property = "password", column = "password")
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "username",  column = "username"),
            @Result(property = "password", column = "password")
    })
    User getOne(int id);

    @Select("select * from user where username=#{0} and password=#{1}")
    @Results({
            @Result(property = "username",  column = "username"),
            @Result(property = "password", column = "password")
    })
    User getOneBypassword(String username,String password);

    @Insert("INSERT INTO user(username,password) VALUES(#{username}, #{password})")
    void insert(User user);

    @Update("UPDATE user SET username=#{username}, WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(int id);

}
