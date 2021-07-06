package io.spring.service;

import java.util.List;

import io.spring.entities.Category;

public interface CategoryService {
	Category create(Category category);
	
	Category update(Category category);
	
	void delete(Integer id);
	
	List<Category> getAllCategories();

	Category getById(String id);

}
