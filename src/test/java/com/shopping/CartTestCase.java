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
		
        cart.setEmail("harkiratiiit@gmail.com");
        cart.setPrice(600);
        cart.setProductname("Java 8	");
        cart.setQuantity(1);
		boolean s = cartDao.save(cart);
		assertEquals("save test", true, s);

	}

	@Test
	public void updateTestCase() {
	
		cart.setEmail("prabh.saharan");
        cart.setPrice(500);
        cart.setProductname("Java Book");
        cart.setQuantity(1);
		
		boolean a = cartDao.update(cart);

		assertEquals(true, a);
	}

	@Test
	public void selectTestCase() {
		cart = cartDao.select(1);
		assertNotNull(cart);
	}

	@Test
	public void deleteTestCase() {

		boolean a = cartDao.delete(1);
		assertEquals(true, a);

	}
	
	@Test
	public void getAllTestCase()
	{
	List<Cart> l=	cartDao.getAll("prabh.saharan");
		assertEquals(2,l.size());
	}

	
	
	
	

}
