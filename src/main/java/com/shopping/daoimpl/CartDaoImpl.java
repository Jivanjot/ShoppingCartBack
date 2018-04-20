package com.shopping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.dao.CartDao;
import com.shopping.domain.Cart;
@Transactional
@Repository(value="cartDao")
public class CartDaoImpl implements CartDao{
	
Logger log=LoggerFactory.getLogger(CartDaoImpl.class);

	 @Autowired
		private SessionFactory sessionFactory;
		
		public boolean save(Cart cart) {
			try {
				log.debug("starting of save method of CartDaoImpl");
				sessionFactory.getCurrentSession().save(cart);
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			log.debug("ending of save method of CartDaoImpl");
			return true;
			
		}

		public Cart select(int id) {
			log.debug("starting of select method of CartDaoImpl");
			return	sessionFactory.getCurrentSession().get(Cart.class, id);
			
			
		}

		public boolean update(Cart cart) {
		
			try {
				log.debug("starting of update method of CartDaoImpl");
				sessionFactory.getCurrentSession().update(cart);
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			log.debug("ending of update method of CartDaoImpl");
			return true;
		}

		public boolean delete(int id) {
		try {
			log.debug("starting of delete method of CartDaoImpl");
			sessionFactory.getCurrentSession().delete(select(id));
		} catch (HibernateException e) {
			e.printStackTrace();	
	         return false;
		}
		log.debug("ending of delete method of CartDaoImpl");
		return true;
			
		
		}
		
		public List<Cart> getAll(String email)
		{
			log.debug("starting of listAll method of CartDaoImpl");
	return	sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("email", email)).list();
			
			
		}
		
		public List<Cart> getAll1(String email,char status)
		{
			log.debug("starting of getAll1 method of CartDaoImpl");
	return	sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("email", email)).add(Restrictions.eq("status", status)).list();
			
			
		}
		
		

		public boolean update1(String email) {
			
		try {
			log.debug("starting of update1 method of CartDaoImpl");
		       String hql="update Cart set status='O' where email='"+email+"'";

			sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
			log.debug("ending of update1 method of CartDaoImpl");
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
}
		
		public List<Cart> getAll2(String email,char status,String supplierId)
		{
			log.debug("starting of getAll2 method of CartDaoImpl");
	return	sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("email", email)).add(Restrictions.eq("status", status)).add(Restrictions.eq("supplierId", supplierId)).list();
			
			
		}

		public List<Cart> getAll3(String email,char status,String productId)
		{
			
			return	sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("email", email)).add(Restrictions.eq("status", status)).add(Restrictions.eq("productId", productId)).list();
	
			
		}

		
		
		
		
}