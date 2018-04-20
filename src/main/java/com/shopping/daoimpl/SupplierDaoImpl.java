package com.shopping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.UniqueKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shopping.dao.SupplierDao;
import com.shopping.domain.Supplier;

@Transactional
@Repository(value = "supplierDao")

public class SupplierDaoImpl implements SupplierDao {

	Logger log = LoggerFactory.getLogger(SupplierDaoImpl.class);
	@Autowired
	public SessionFactory sessionFactory;

	public boolean save(Supplier supplier) {
		try {
			log.debug("starting of save method of SupplierDaoImpl");

			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		log.debug("ending of save method of SupplierDaoImpl");
		return true;
	}

	public Supplier select(String id) {
		log.debug("starting of select method of SupplierDaoImpl");

		return sessionFactory.getCurrentSession().get(Supplier.class, id);

	}

	public boolean update(Supplier supplier) {

		try {
			log.debug("starting of update method of SupplierDaoImpl");

			sessionFactory.getCurrentSession().update(supplier);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		log.debug("ending of update method of SupplierDaoImpl");

		return true;
	}

	public boolean delete(String id) {
		try {
			log.debug("starting of delete method of SupplierDaoImpl");

			sessionFactory.getCurrentSession().delete(select(id));
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		log.debug("ending of delete method of SupplierDaoImpl");

		return true;

	}

	public List<Supplier> getAll() {
		log.debug("starting of getAll method of SupplierDaoImpl");

		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();

	}

}
