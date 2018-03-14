package com.shopping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.shopping.dao.CategoryDao;
import com.shopping.domain.Category;

public class CategoryTestCase {
	@Autowired
	private static Category category;
	@Autowired
	private static CategoryDao categoryDao;

	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shopping");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
		category = (Category) context.getBean("category");

	}

	@Test
	public void saveTestCase() {
		category = new Category();
         category.setId("cfg");
         category.setName("ghjf");
         category.setDescription("this is sdfu");
		
		boolean s = categoryDao.save(category);
		assertEquals("save test", true, s);

	}

	@Test
	public void updateTestCase() {
	
	     category.setId("cfg");
         category.setName("gqwhjf");
         category.setDescription("qwewthis is sdfu");
	
		boolean a = categoryDao.update(category);

		assertEquals(true, a);
	}

	@Test
	public void selectTestCase() {
		category = categoryDao.select("cfg");
		assertNotNull(category);
	}

	@Test
	public void deleteTestCase() {

		boolean a = categoryDao.delete("cfg");
		assertEquals(true, a);

	}
	
	@Test
	public void getAllTestCase()
	{
	List<Category> l=	categoryDao.getAll();
		assertEquals(1,l.size());
	}

	
	
}
