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

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired
	private static Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit"); 
		
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		category = (Category)context.getBean("category");
	}
	@Ignore
	
	@Test
	public void saveCategoryTestCase()
	{
		category = new Category();
		category.setId("M006");
		category.setName("Lap");
		category.setDescription("This is Dell  category");
		
	  boolean status = 	categoryDAO.save(category);
	  
	  assertEquals("save category test case", true, status);
	}
	
	//@Ignore
	@Test
	public void updateCategoryTestCase()
	{
		category.setId("M002");
		category.setName("Lap");
		category.setDescription("This is Dell  category");
		boolean status = categoryDAO.update(category);
		assertEquals("update test case", true,status );
	}
	@Ignore
	@Test
	public void getCategorySuccessTestCase()
	{
		
	category= categoryDAO.get("M002");
	
	assertNotNull("get category test case", category);
	}
	@Ignore
	@Test
	public void getCategoryFailureTestCase()
	{
		
	category= categoryDAO.get("M002");
	
	assertNull("get category test case", category);
	}
	@Ignore
	@Test
	public void deleteCategorySuccessTestCase()
	{
	boolean status =	categoryDAO.delete("M002");
	assertEquals("delete category succss test case" , true, status);
	
	}
	@Ignore
	@Test
	public void deleteCategoryFailureTestCase()
	{
	boolean status =	categoryDAO.delete("M002");
	assertEquals("delete category failure test case" , false, status);
	
	}
	
	@Ignore
	@Test
	public void getAllCategorysTestCase()
	{
	List<Category>	categorys = categoryDAO.list();
	
	assertEquals("get all usres " , 2, categorys.size() );
	
	}
	
	
		
	
	
	
	
	
	
	
	
}
