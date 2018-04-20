package com.shopping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shopping.dao.UserDao;
import com.shopping.domain.User;

@Transactional
@Repository(value = "userDao")

public class UserDaoImpl implements UserDao {

	Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	public SessionFactory sessionFactory;

	public boolean save(User user) {
		try {
			log.debug("starting save method on userDaoImpl");
			sessionFactory.getCurrentSession().save(user);

		} catch (HibernateException e) {
			e.printStackTrace();
			log.debug("exception in save method of userDaoImpl", e);
			return false;
		}
		log.debug("ending of save method of userDaoImpl");
		return true;
	}

	public User select(String email) {
		log.debug("starting select method on userDaoImpl");

		return sessionFactory.getCurrentSession().get(User.class, email);

	}

	public boolean update(User user) {

		try {
			log.debug("starting update method on userDaoImpl");

			sessionFactory.getCurrentSession().update(user);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		log.debug("ending of update method of userDaoImpl");

		return true;
	}

	public boolean delete(String email) {
		try {
			log.debug("starting of delete method of userDaoImpl");

			sessionFactory.getCurrentSession().delete(select(email));
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		log.debug("ending of delete method of userDaoImpl");
		return true;

	}

	public List<User> getAll() {
		log.debug("starting of getAll method of userDaoImpl");

		return sessionFactory.getCurrentSession().createQuery("from User").list();

	}

	public User validate(String email, String password) {

		log.debug("starting of validate method of userDaoImpl");

		return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password)).uniqueResult();

	}
	
	public boolean update1(String email,String address) {
		
		try {
			sessionFactory.getCurrentSession().createQuery("update User set address='"+address+"' where email='"+email+"'").executeUpdate();
		  return true;
		} catch (HibernateException e) {
			return false;


		}
	}


}
