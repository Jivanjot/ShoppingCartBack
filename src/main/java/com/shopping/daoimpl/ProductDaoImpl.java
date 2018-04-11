package com.shopping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shopping.dao.ProductDao;
import com.shopping.domain.Product;


@Transactional
@Repository(value="productDao")

public class ProductDaoImpl implements ProductDao{

	Logger log=LoggerFactory.getLogger(ProductDaoImpl.class);
	
@Autowired
	public SessionFactory sessionFactory;

    
 
	public boolean save(Product product) {
		try {
			log.debug("starting of save method of ProductDaoImpl");

			sessionFactory.getCurrentSession().saveOrUpdate(product);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		log.debug("ending of save method of ProductDaoImpl");

		return true;
	}

	public Product select(String id) {
		log.debug("starting of select method of ProductDaoImpl");

		return	sessionFactory.getCurrentSession().get(Product.class, id);
		
		
	}

	public boolean update(Product product) {
	
		try {
			log.debug("starting of update method of ProductDaoImpl");

			sessionFactory.getCurrentSession().update(product);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		log.debug("ending of update method of ProductDaoImpl");

		return true;
	}

	public boolean delete(String id) {
	try {
		log.debug("starting of delete method of ProductDaoImpl");

		sessionFactory.getCurrentSession().delete(select(id));
	} catch (HibernateException e) {
		e.printStackTrace();	
         return false;
	}
	log.debug("starting of delete method of ProductDaoImpl");

	return true;
	
		
	
	}
	
	public List<Product> getAll()
	{
		log.debug("starting of list method of ProductDaoImpl");

return	sessionFactory.getCurrentSession().createQuery("from Product order by id").list();
		
		
	}
	public List<Product> onBasisSupplierId(String SupplierId) {
		
		log.debug("starting of listOnBasisSupplierId method of ProductDaoImpl");

		return	sessionFactory.getCurrentSession().createQuery("from Product where supplierId='"+SupplierId+"'").list();
			
		}
	
	
	

	
	}
	
	

