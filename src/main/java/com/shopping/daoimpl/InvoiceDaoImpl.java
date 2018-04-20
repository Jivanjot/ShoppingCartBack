package com.shopping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.dao.InvoiceDao;
import com.shopping.domain.Invoice;

@Transactional
@Repository(value = "invoiceDao")
public class InvoiceDaoImpl implements InvoiceDao {

	Logger log = LoggerFactory.getLogger(InvoiceDaoImpl.class);

	@Autowired
	public SessionFactory sessionFactory;

	public boolean save(Invoice invoice) {
		try {
			log.debug("starting save method on InvoiceDaoImpl");
			sessionFactory.getCurrentSession().save(invoice);

		} catch (HibernateException e) {
			e.printStackTrace();
			log.debug("exception in save method of InvoiceDaoImpl", e);
			return false;
		}
		log.debug("ending of save method of InvoiceDaoImpl");
		return true;
	}

	public Invoice select(int orderId) {
		log.debug("starting select method on InvoiceDaoImpl");

		return sessionFactory.getCurrentSession().get(Invoice.class, orderId);

	}

	public boolean update(Invoice invoice) {

		try {
			log.debug("starting update method on InvoiceDaoImpl");

			sessionFactory.getCurrentSession().update(invoice);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		log.debug("ending of update method of InvoiceDaoImpl");

		return true;
	}

	public boolean delete(int orderId) {
		try {
			log.debug("starting of delete method of InvoiceDaoImpl");

			sessionFactory.getCurrentSession().delete(select(orderId));
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		log.debug("ending of delete method of InvoiceDaoImpl");
		return true;

	}

	public List<Invoice> getAll() {
		log.debug("starting of getAll method of InvoiceDaoImpl");

		return sessionFactory.getCurrentSession().createQuery("from Invoice").list();

	}

}
