package com.krefer.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krefer.blog.payloads.CategoryDto;


public interface CategoryService {

	// create
	CategoryDto createCategory(CategoryDto categoryDto);
	// update

	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// delete

	void deleteCategory(Integer categoryId);
	// get

	CategoryDto getCategory(Integer categoryId);
	// get all

	List<CategoryDto> getCategories();
}
