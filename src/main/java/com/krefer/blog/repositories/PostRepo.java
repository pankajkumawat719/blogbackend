package com.krefer.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krefer.blog.entity.Category;
import com.krefer.blog.entity.Post;
import com.krefer.blog.entity.User;

public interface PostRepo  extends JpaRepository<Post, Integer>{

	List<Post> getByUser(User user);
	List<Category> getByCategory(Category category);
}
