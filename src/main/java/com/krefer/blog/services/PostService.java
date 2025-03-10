package com.krefer.blog.services;

import java.util.List;

import com.krefer.blog.entity.Post;
import com.krefer.blog.payloads.PostDto;
import com.krefer.blog.payloads.PostResponse;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId,Integer categoryId);

	// update post
	PostDto updatePost(PostDto postDto, Integer postId);

	// delete post
	void deletePost(Integer postId);

	// get all post
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy,String sortDir);

	// get a single post
	PostDto getPostById(Integer postId);

	// get post by Category
	List<PostDto> getPostByCategory(Integer categoryId);

	// get post by user

	List<PostDto> getPostByUser(Integer userId);

	// get post by keyword / search

	List<PostDto> getPostBySearch(String keyword);
}
