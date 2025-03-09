package com.krefer.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krefer.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
