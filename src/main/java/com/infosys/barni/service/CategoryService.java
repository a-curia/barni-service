package com.infosys.barni.service;

import java.util.List;

import com.infosys.barni.entity.Category;

public interface CategoryService {
	public List<Category> getAllCategory();
	public Category getCategoryById(long id);
	public Category saveCategory(Category category);
	public void removeCategory(Category category);
}