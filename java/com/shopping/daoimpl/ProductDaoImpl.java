package com.shopping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shopping.dao.ProductDao;
import com.shopping.domain.Product;


@Transactional
@Repository(value="productDao")

public class ProductDaoImpl implements ProductDao{

@Autowired
	public SessionFactory sessionFactory;

    
 
	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Product select(String id) {
	
		return	sessionFactory.getCurrentSession().get(Product.class, id);
		
		
	}

	public boolean update(Product product) {
	
		try {
			sessionFactory.getCurrentSession().update(product);
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
	
	public List<Product> getAll()
	{
return	sessionFactory.getCurrentSession().createQuery("from Product order by Product.id").list();
		
		
	}

	
	
	

	
	}
	
	

