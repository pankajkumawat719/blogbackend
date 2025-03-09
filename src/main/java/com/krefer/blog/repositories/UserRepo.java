package com.krefer.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krefer.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
