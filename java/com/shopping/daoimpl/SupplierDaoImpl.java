package com.shopping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.UniqueKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shopping.dao.SupplierDao;
import com.shopping.domain.Supplier;


@Transactional
@Repository(value="supplierDao")

public class SupplierDaoImpl implements SupplierDao{

@Autowired
	public SessionFactory sessionFactory;

    
 
	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Supplier select(String email) {
	
		return	sessionFactory.getCurrentSession().get(Supplier.class, email);
		
		
	}

	public boolean update(Supplier supplier) {
	
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(String email) {
	try {
		sessionFactory.getCurrentSession().delete(select(email));
	} catch (HibernateException e) {
		e.printStackTrace();	
         return false;
	}
	return true;
		
	
	}
	
	public List<Supplier> getAll()
	{
return	sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		
		
	}
	
	

	
	
	

	
	}
	
	

