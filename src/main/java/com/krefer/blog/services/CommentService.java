package com.krefer.blog.services;

import com.krefer.blog.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postID);
	void deleteComment(Integer commentId);
}
