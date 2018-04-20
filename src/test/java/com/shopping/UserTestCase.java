package com.shopping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.dao.UserDao;
import com.shopping.domain.User;

public class UserTestCase {

	@Autowired
	private static User user;
	@Autowired
	private static UserDao userDao;

	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shopping");
		context.refresh();
		userDao = (UserDao) context.getBean("userDao");
		user = (User) context.getBean("user");

	}

	@Test
	public void saveTestCase() {
		//user = new User();
		user.setName("Goga");
		user.setPassword("GOga1!");
		user.setEmail("singh.goga@gmail.com");
		user.setMobile("456367");
		user.setAddress("Moga");
		user.setRegisterdate();
		user.setRole('C');
		
		
		boolean s = userDao.save(user);
		assertEquals(true, s);

	}

	@Test
	public void updateTestCase() {
	
		
		user.setName("Goga");
		user.setPassword("GOga1!");
		user.setEmail("singh.goga@gmail.com");
		user.setMobile("456367");
		user.setAddress("Tarewala");
		user.setRegisterdate();
		user.setRole('C');
		
		boolean a = userDao.update(user);

		assertEquals(true, a);
	}

	@Test
	public void selectTestCase() {
		user = userDao.select("singh.goga@gmail.com");
		assertNotNull(user);
	}

	@Test
	public void deleteTestCase() {

		boolean a = userDao.delete("singh.goga@gmail.com");
		assertEquals(true, a);

	}
	
	@Test
	public void getAllTestCase()
	{
	List<User> l=	userDao.getAll();
		assertEquals(2,l.size());
	}

	@Test
	public void validateTestCase()
	{
	user=userDao.validate("singh.goga@gmal.com","GOga1!");
	assertNotNull(user);
	
	}
	

}
