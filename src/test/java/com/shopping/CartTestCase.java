package com.shopping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.dao.CartDao;
import com.shopping.domain.Cart;

public class CartTestCase {



	@Autowired
	private static Cart cart;
	@Autowired
	private static CartDao cartDao;

	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shopping");
		context.refresh();
		cartDao = (CartDao) context.getBean("cartDao");
		cart = (Cart) context.getBean("cart");

	}

	@Test
	public void saveTestCase() {
		//cart = new Cart();
		
		cart.setEmail("dfghdhfgx");
		cart.setId(5);
		cart.setPrice(500);
		cart.setProductId("4");
		cart.setProductname("ethfg");
		cart.setQuantity(5);
		cart.setStatus();
		cart.setSupplierId("7");
		
		boolean s = cartDao.save(cart);
		assertEquals(true, s);

	}

	@Test
	public void updateTestCase() {
	

		cart.setEmail("dfghdhfgx");
		cart.setId(5);
		cart.setPrice(466);
		cart.setProductId("4");
		cart.setProductname("ethfg");
		cart.setQuantity(5);
		cart.setStatus();
		cart.setSupplierId("7");		
		boolean a = cartDao.update(cart);

		assertEquals(true, a);
	}

	@Test
	public void selectTestCase() {
		cart = cartDao.select(5);
		assertNotNull(cart);
	}

	@Test
	public void deleteTestCase() {

		boolean a = cartDao.delete(5);
		assertEquals(true, a);

	}
	
	@Test
	public void getAllTestCase()
	{
	List<Cart> l=	cartDao.getAll("dfd");
		assertEquals(2,l.size());
	}

	@Test
	public void getAll1TestCase()
	{
	List<Cart> l=	cartDao.getAll1("dfd",'N');
		assertEquals(2,l.size());
	}


}
