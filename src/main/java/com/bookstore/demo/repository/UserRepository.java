package com.bookstore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.demo.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserById(int id);

    void deleteById(int id);

    User getUserByUsernameAndPassword(String Username,String Password);
}
