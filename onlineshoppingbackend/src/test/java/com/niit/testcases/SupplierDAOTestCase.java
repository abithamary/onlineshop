package com.niit.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static Supplier supplier;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit"); 
		
		context.refresh();
		
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		supplier = (Supplier)context.getBean("supplier");
	}
	//@Ignore
	@Test
	public void saveSupplierTestCase()
	{
		supplier = new Supplier();
		supplier.setId("SUP-005");
		supplier.setName("Adarsh");
		supplier.setAddress("Bengal");
		
	  boolean status = 	supplierDAO.save(supplier);
	  
	  assertEquals("save supplier test case", true, status);
	}
	
	@Ignore
	
	@Test
	public void updateSupplierTestCase()
	{
		supplier.setId("SUP-001");
		supplier.setName("Sureh");
		supplier.setAddress("Ameerpet , Hyderabad");
		boolean status = supplierDAO.update(supplier);
		assertEquals("update test case", true,status );
	}
	@Ignore
	
	@Test
	public void getSupplierSuccessTestCase()
	{
		
	supplier= supplierDAO.get("SUP-001");
	
	assertNotNull("get supplier test case", supplier);
	}
	@Ignore
	
	@Test
	public void getSupplierFailureTestCase()
	{
		
	supplier= supplierDAO.get("SUP-001");
	
	assertNull("get supplier test case", supplier);
	}
	@Ignore
	
	@Test
	public void deleteSupplierSuccessTestCase()
	{
	boolean status =	supplierDAO.delete("SUP-001");
	assertEquals("delete supplier succss test case" , true, status);
	
	}
	@Ignore
	
	@Test
	public void deleteSupplierFailureTestCase()
	{
	boolean status =	supplierDAO.delete("SUP-001");
	assertEquals("delete supplier failure test case" , false, status);
	
	}
	
	@Ignore
	
	@Test
	public void getAllSuppliersTestCase()
	{
	List<Supplier>	suppliers = supplierDAO.list();
	
	assertEquals("get all usres " , 3, suppliers.size() );
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
