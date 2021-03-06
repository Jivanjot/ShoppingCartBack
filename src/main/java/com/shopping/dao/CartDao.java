package com.shopping.dao;

import java.util.List;

import com.shopping.domain.Cart;

public interface CartDao {
	
public boolean save(Cart cart);
	
	
	public Cart select(int id);
	
	public boolean update(Cart cart);
	
	public boolean delete(int id);
	
	public List<Cart> getAll(String email);

	public List<Cart> getAll1(String email,char status);
	
	public List<Cart> getAll2(String email,char status,String supplierId);

	public List<Cart> getAll3(String email,char status,String productId);
	public boolean update1(String email);
	
}
