package com.bookstore.demo.repository;

import com.bookstore.demo.entity.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<book,Integer> {

    boolean deleteBookById(int id);

    book queryBookById(int id);

}
