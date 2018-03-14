package com.shopping.dao;

import java.util.List;

import com.shopping.domain.Supplier;

public interface SupplierDao {
	
public boolean save(Supplier supplier);
	
	
	public Supplier select(String id);
	
	public boolean update(Supplier supplier);
	
	public boolean delete(String id);
	
	public List<Supplier> getAll();

}
