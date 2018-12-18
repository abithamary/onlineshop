package com.niit.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;



public class ProductDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static ProductDAO productDAO;
	
	@Autowired
	private static Product product;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit"); 
		
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
		product = (Product)context.getBean("product");
	}
	//@Ignore
	
	@Test
	public void saveProductTestCase()
	{
		product = new Product();
		product.setId("Samsung-04");
		product.setName("S1007 Model");
		product.setDescription("This is Samsung  product");
		product.setCategoryId("M003");
		product.setPrice(6000);
		product.setSupplierId("SUP-004");
	  boolean status = 	productDAO.save(product);
	  
	  assertEquals("save product test case", true, status);
	}
	
	@Ignore
	
	@Test
	public void updateProductTestCase()
	{
		product.setId("Samsung-01");
		product.setName("S10003Model");
		product.setDescription("This is Samsung product");
		boolean status = productDAO.update(product);
		assertEquals("update test case", true,status );
	}
	@Ignore
	
	@Test
	public void getProductSuccessTestCase()
	{
		
	product= productDAO.get("Samsung-01");
	
	assertNotNull("get product test case", product);
	}
	@Ignore
	
	@Test
	public void getProductFailureTestCase()
	{
		
	product= productDAO.get("Samsung-01");
	
	assertNull("get product test case", product);
	}
	@Ignore
	
	@Test
	public void deleteProductSuccessTestCase()
	{
	boolean status =	productDAO.delete("Samsung-05");
	assertEquals("delete product succss test case" , true, status);
	
	}
	@Ignore
	
	@Test
	public void deleteProductFailureTestCase()
	{
	boolean status =	productDAO.delete("Samsung-01");
	assertEquals("delete product failure test case" , false, status);
	
	}
	
	@Ignore
	
	@Test
	public void getAllProductsTestCase()
	{
	List<Product>	products = productDAO.list();
	
	assertEquals("get all products " , 3, products.size() );
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
