package com.ashokit.service;


import com.ashokit.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

	// create
	CategoryDto createCategory(CategoryDto categoryDto);

	// update
	CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);

	// delete
	void deleteCategory(Long categoryId);

	// get
	CategoryDto getCategory(Long categoryId);

	// get All

	List<CategoryDto> getCategories();

}
