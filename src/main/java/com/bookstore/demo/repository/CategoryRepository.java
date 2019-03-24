package com.bookstore.demo.repository;

import com.bookstore.demo.entity.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<category,Integer> {

    @Modifying@Transactional
    @Query("update category sc set sc.name = ?2 where sc.id = ?1")
    void updateName(@Param(value = "id")int id,@Param(value="name")String name);
}
