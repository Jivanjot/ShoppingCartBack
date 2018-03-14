package com.shopping.dao;

import java.util.List;

import com.shopping.domain.Category;


public interface CategoryDao {
	
public boolean save(Category category);
	
	
	public Category select(String id);
	
	public boolean update(Category category);
	
	public boolean delete(String id);
	
	public List<Category> getAll();
	
	

}
