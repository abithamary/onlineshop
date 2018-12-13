package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;


//DAO -> Data Access Object
public interface SupplierDAO {
	
	//declare the methods.
	
	//create new supplier
	
	public boolean save(Supplier supplier);
	
	
	//update the existing supplier
	
	public boolean update(Supplier supplier);
	
	
	//get the supplier details
	
	public   Supplier     get(String id);
	
	
	//delete the supplier
	
	public   boolean    delete(String id);
	
	//to get all the suppliers
	public List<Supplier>   list();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
