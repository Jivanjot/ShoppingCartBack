package com.shopping.dao;

import java.util.List;

import com.shopping.domain.Product;

public interface ProductDao {
public boolean save(Product product);
	
	
	public Product select(String id);
	
	public boolean update(Product product);
	
	public boolean delete(String id);
	
	public List<Product> getAll();
	

}
