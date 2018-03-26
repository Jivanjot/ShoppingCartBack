package com.shopping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shopping.dao.UserDao;
import com.shopping.domain.User;


@Transactional
@Repository(value="userDao")

public class UserDaoImpl implements UserDao{

@Autowired
	public SessionFactory sessionFactory;

    
 
	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public User select(String email) {
	
		return	sessionFactory.getCurrentSession().get(User.class, email);
		
		
	}

	public boolean update(User user) {
	
		try {
			sessionFactory.getCurrentSession().update(user);
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
	
	public List<User> getAll()
	{
return	sessionFactory.getCurrentSession().createQuery("from User").list();
		
		
	}
	
	public User validate(String email,String password) {
		
	return	(User) sessionFactory.getCurrentSession().createCriteria(User.class)
			.add(Restrictions.eq("email",email)).add(Restrictions.eq("password", password)).uniqueResult();
		
		
		
	}

	
	
	

	
	}
	
	

