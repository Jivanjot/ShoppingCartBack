package com.shopping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.dao.InvoiceDao;
import com.shopping.domain.Invoice;

public class InvoiceTestCase {
	@Autowired
	private static Invoice invoice;
	@Autowired
	private static InvoiceDao invoiceDao;

	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shopping");
		context.refresh();
		invoiceDao = (InvoiceDao) context.getBean("invoiceDao");
		invoice = (Invoice) context.getBean("invoice");

	}

	@Test
	public void saveTestCase() {
		//invoice = new Invoice();
		invoice.setInvoiceId(123);
		invoice.setOrderId(12);
		invoice.setProducts("2,4,6");
		invoice.setOrderDate();
		
		boolean s = invoiceDao.save(invoice);
		assertEquals(true, s);

	}

	@Test
	public void updateTestCase() {
	
		invoice.setInvoiceId(123);
		invoice.setOrderId(12);
		invoice.setProducts("2,4,6,8");
		invoice.setOrderDate();
		
		boolean a = invoiceDao.update(invoice);

		assertEquals(true, a);
	}

	@Test
	public void selectTestCase() {
	Invoice invoice=	invoiceDao.select(12);
		assertNotNull(invoice);
	}

	@Test
	public void deleteTestCase() {

		boolean a = invoiceDao.delete(12);
		assertEquals(true, a);

	}
	
	@Test
	public void getAllTestCase()
	{
	List<Invoice> l=	invoiceDao.getAll();
		assertEquals(2,l.size());
	}


}
