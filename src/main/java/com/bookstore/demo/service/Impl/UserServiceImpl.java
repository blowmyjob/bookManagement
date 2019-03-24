package com.bookstore.demo.service.Impl;

import com.bookstore.demo.entity.User;
import com.bookstore.demo.mapper.UserMapper;
import com.bookstore.demo.repository.UserRepository;
import com.bookstore.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getAll();
    }

    @Override
    public User findUserById(int id) {
       return null;
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public boolean findUser(User user){
        if(userMapper.getOneBypassword(user.getUsername(),user.getPassword())!=null)
            return true;
        else
            return false;
    }
}

