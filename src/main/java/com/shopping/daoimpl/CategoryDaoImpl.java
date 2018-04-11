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
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shopping.dao.CategoryDao;
import com.shopping.domain.Category;
import com.shopping.domain.Category;

@Transactional
@Repository(value="categoryDao")

public class CategoryDaoImpl implements CategoryDao {
	
	Logger log=LoggerFactory.getLogger(CategoryDaoImpl.class);
    @Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(Category category) {
		try {
			log.debug("starting of save method of CategoryDaoImpl");

			sessionFactory.getCurrentSession().saveOrUpdate(category);
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		log.debug("ending of save method of CategoryDaoImpl");

		return true;
		
	}

	public Category select(String id) {
		log.debug("starting of select method of CategoryDaoImpl");

		return	sessionFactory.getCurrentSession().get(Category.class, id);
		
		
	}

	public boolean update(Category category) {
	
		try {
			log.debug("starting of update method of CategoryDaoImpl");
			sessionFactory.getCurrentSession().update(category);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		log.debug("ending of update method of CategoryDaoImpl");
		return true;
	}

	public boolean delete(String id) {
	try {
		log.debug("starting of delete method of CategoryDaoImpl");
		sessionFactory.getCurrentSession().delete(select(id));
	} catch (HibernateException e) {
		e.printStackTrace();	
         return false;
	}
	log.debug("ending of delete method of CategoryDaoImpl");
	return true;
		
	
	}
	
	public List<Category> getAll()
	{
		log.debug("starting of listAll method of CategoryDaoImpl");
return	sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		
	}
		

}
