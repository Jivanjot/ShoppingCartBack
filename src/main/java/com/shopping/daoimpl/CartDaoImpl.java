package com.shopping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.dao.CartDao;
import com.shopping.domain.Cart;
@Transactional
@Repository(value="cartDao")
public class CartDaoImpl implements CartDao{

	 @Autowired
		private SessionFactory sessionFactory;
		
		public boolean save(Cart cart) {
			try {
				sessionFactory.getCurrentSession().save(cart);
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
			
		}

		public Cart select(int id) {
			
			return	sessionFactory.getCurrentSession().get(Cart.class, id);
			
			
		}

		public boolean update(Cart cart) {
		
			try {
				sessionFactory.getCurrentSession().update(cart);
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public boolean delete(int id) {
		try {
			sessionFactory.getCurrentSession().delete(select(id));
		} catch (HibernateException e) {
			e.printStackTrace();	
	         return false;
		}
		return true;
			
		
		}
		
		public List<Cart> getAll(String email)
		{
	return	sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("email", email)).list();
			
			
		}
	
}
