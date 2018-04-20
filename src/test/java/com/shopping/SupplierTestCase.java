package com.shopping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.dao.SupplierDao;
import com.shopping.domain.Supplier;

public class SupplierTestCase {

	@Autowired
	private static Supplier supplier;
	@Autowired
	private static SupplierDao supplierDao;

	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shopping");
		context.refresh();
		supplierDao = (SupplierDao) context.getBean("supplierDao");
		supplier = (Supplier) context.getBean("supplier");

	}

	@Test
	public void saveTestCase() {
		//supplier = new Supplier();
		
		supplier.setAddress("xdfbdg");
		supplier.setEmail("rgdzg");
		supplier.setId("2");
		supplier.setName("dgsgb");
		
		
		boolean s = supplierDao.save(supplier);
		assertEquals(true, s);

	}

	@Test
	public void updateTestCase() {
	

		supplier.setAddress("xdfbdg");
		supplier.setEmail("rgdzg");
		supplier.setId("72");
		supplier.setName("dgsgb");
		
		boolean a = supplierDao.update(supplier);

		assertEquals(true, a);
	}

	@Test
	public void selectTestCase() {
		supplier = supplierDao.select("rgdzg");
		assertNotNull(supplier);
	}

	@Test
	public void deleteTestCase() {

		boolean a = supplierDao.delete("rgdzg");
		assertEquals(true, a);

	}
	
	@Test
	public void getAllTestCase()
	{
	List<Supplier> l=	supplierDao.getAll();
		assertEquals(2,l.size());
	}

	

}
