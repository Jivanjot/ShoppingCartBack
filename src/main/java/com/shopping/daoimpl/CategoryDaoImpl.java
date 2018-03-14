package com.shopping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shopping.dao.CategoryDao;
import com.shopping.domain.Category;
import com.shopping.domain.Category;
@Repository(value="categoryDao")
@Transactional


public class CategoryDaoImpl implements CategoryDao {
    @Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	public Category select(String id) {
		
		return	sessionFactory.getCurrentSession().get(Category.class, id);
		
		
	}

	public boolean update(Category category) {
	
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(String id) {
	try {
		sessionFactory.getCurrentSession().delete(select(id));
	} catch (HibernateException e) {
		e.printStackTrace();	
         return false;
	}
	return true;
		
	
	}
	
	public List<Category> getAll()
	{
return	sessionFactory.getCurrentSession().createQuery("from Category").list();
		
		
	}
		

}
