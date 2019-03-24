package com.bookstore.demo.service;

import com.bookstore.demo.entity.*;
import java.util.List;

public interface UserService {
    public List<User> getUserList();

    public User findUserById(int id);

    public void save(User user);

    public void edit(User user);

    public void delete(int id);

    public boolean findUser(User user);
}
