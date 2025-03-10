package com.krefer.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krefer.blog.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
