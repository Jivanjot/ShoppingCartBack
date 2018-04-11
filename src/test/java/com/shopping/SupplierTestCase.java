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
		supplier = new Supplier();
         supplier.setId("1");
         supplier.setName("ghjf");
         supplier.setAddress("this is sdfu");
		
		boolean s = supplierDao.save(supplier);
		assertEquals("save test", true, s);

	}

	@Test
	public void updateTestCase() {
	
	     supplier.setId("1");
         supplier.setName("gqwhjf");
         supplier.setAddress("qwewthis is sdfu");
	
		boolean a = supplierDao.update(supplier);

		assertEquals(true, a);
	}

	@Test
	public void selectTestCase() {
		supplier = supplierDao.select("1");
		assertNotNull(supplier);
	}

	@Test
	public void deleteTestCase() {

		boolean a = supplierDao.delete("1");
		assertEquals(true, a);

	}
	
	@Test
	public void getAllTestCase()
	{
	List<Supplier> l=	supplierDao.getAll();
		assertEquals(1,l.size());
	}

	
	
}
