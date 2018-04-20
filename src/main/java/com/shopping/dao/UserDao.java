package com.shopping.dao;

import java.util.List;

import com.shopping.domain.User;


public interface UserDao {
	
	public boolean save(User user);
	
	
	public User select(String email);
	
	public boolean update(User user);
	
	public boolean delete(String email);
	
	public List<User> getAll();

     public User validate(String email,String password);
     public boolean update1(String email,String address);


}
