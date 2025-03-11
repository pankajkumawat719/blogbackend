package com.krefer.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krefer.blog.entity.Comment;
import com.krefer.blog.entity.Post;
import com.krefer.blog.exception.ResourceNotFoundException;
import com.krefer.blog.payloads.CommentDto;
import com.krefer.blog.repositories.CommentRepo;
import com.krefer.blog.repositories.PostRepo;
import com.krefer.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postID) {
		Post post = this.postRepo.findById(postID)
				.orElseThrow(() -> new ResourceNotFoundException("post", "post id", postID));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("comment", "commend id ", commentId));
		this.commentRepo.delete(com);

	}

}
