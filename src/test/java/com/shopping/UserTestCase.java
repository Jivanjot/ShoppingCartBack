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
		user.setEmail("singh.harkirat");
		user.setMobile("84518");
		user.setName("Harkirat Singh");
		user.setPassword("ASDfgh");
		user.setRole('A');
		user.setRegisterdate();

		boolean s = userDao.save(user);
		assertEquals(true, s);

	}

	@Test
	public void updateTestCase() {
	
		user.setEmail("prabh.saharan");
		user.setName("jivan");
		user.setMobile("8115318115");
		user.setPassword("hjui");
		user.setRole('C');
		user.setRegisterdate();
		boolean a = userDao.update(user);

		assertEquals(true, a);
	}

	@Test
	public void selectTestCase() {
		user = userDao.select("wqe");
		assertNotNull(user);
	}

	@Test
	public void deleteTestCase() {

		boolean a = userDao.delete("dw");
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
	user=userDao.validate("dw","hj");
	assertNotNull(user);
	
	}
	
	
}
