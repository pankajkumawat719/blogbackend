package com.krefer.blog.payloads;

import java.util.Date;

import com.krefer.blog.entity.Category;
import com.krefer.blog.entity.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PostDto {

	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UserDto user;

}
