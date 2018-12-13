package com.niit.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;


public class CategoryTestCase {

	/*private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired
	private static Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		//scan the complete package and check for annoations like
		//@Component, @Controller, @Repository, @Service
		context.scan("com.niit"); 
		//clear the context(bean factory, and recreate all the
		//instances of the classes which are there in com.niit
		//with proper annotations.
		context.refresh();
		//ask the context to get instance of CategoryDAO
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		category = (Category)context.getBean("category");
	}
	//@Ignore
	
	@Test
	public void saveCategoryTestCase()
	{
		category = new Category();
		category.setId("Bookes001");
		category.setName("Book");
		category.setDescription("This is Book category");
		
	  boolean status = 	categoryDAO.save(category);
	  
	  assertEquals("save category test case", true, status);
	}
	
	@Ignore
	@Test
	public void updateCategoryTestCase()
	{
		category.setId("Mob-001");
		category.setName("Mobile");
		category.setDescription("This is new mobile category");
		boolean status = categoryDAO.update(category);
		assertEquals("update test case", true,status );
	}
	@Ignore
	@Test
	public void getCategorySuccessTestCase()
	{
		
	category= categoryDAO.get("jaskaran1@gmail.com");
	
	assertNotNull("get category test case", category);
	}
	@Ignore
	@Test
	public void getCategoryFailureTestCase()
	{
		
	category= categoryDAO.get("jaya@gmail.com");
	
	assertNull("get category test case", category);
	}
	@Ignore
	@Test
	public void deleteCategorySuccessTestCase()
	{
	boolean status =	categoryDAO.delete("jaskaran1@gmail.com");
	assertEquals("delete category succss test case" , true, status);
	
	}
	@Ignore
	@Test
	public void deleteCategoryFailureTestCase()
	{
	boolean status =	categoryDAO.delete("arpith@gmail.com");
	assertEquals("delete category failure test case" , false, status);
	
	}
	
	@Ignore
	@Test
	public void getAllCategorysTestCase()
	{
	List<Category>	categorys = categoryDAO.list();
	
	assertEquals("get all usres " , 5, categorys.size() );
	
	}
	
	
	*/	
	
	
	
	
	
	
	
	
}
