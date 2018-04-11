package com.shopping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.shopping.dao.ProductDao;
import com.shopping.domain.Product;

public class ProductTestCase {
	@Autowired
	private static Product product;
	@Autowired
	private static ProductDao productDao;

	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shopping");
		context.refresh();
		productDao = (ProductDao) context.getBean("productDao");
		product = (Product) context.getBean("product");

	}

	@Test
	public void saveTestCase() {
		product = new Product();
         product.setId("7");
         product.setName("Computers");
         product.setDescription("This is a computer category  ");
		product.setCategoryId("ELEC");
	product.setSupplierId("2");
	product.setPrice(1000);
		boolean s = productDao.save(product);
		assertEquals("save test", true, s);

	}

	@Test
	public void updateTestCase() {
	
	     product.setId("3");
         product.setName("Samsung");
         product.setDescription("This is Samsung phone category	");
         product.setCategoryId("MOB");
	product.setSupplierId("2");
	product.setPrice(2000);
		boolean a = productDao.update(product);

		assertEquals(true, a);
	}

	@Test
	public void selectTestCase() {
		product = productDao.select("2");
		assertNotNull(product);
	}

	@Test
	public void deleteTestCase() {

		boolean a = productDao.delete("1");
		assertEquals(true, a);

	}
	
	@Test
	public void getAllTestCase()
	{
	List<Product> l=	productDao.getAll();
		assertEquals(1,l.size());
	}

	
	@Test
	public void onBasisSupplierIdTestCase()
	{
		List<Product> products=	productDao.onBasisSupplierId("2");
		assertEquals(1, products.size());
	}
	
	
}
