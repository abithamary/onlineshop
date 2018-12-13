package com.niit.dao;

import java.util.List;

import com.niit.model.User;



//DAO -> Data Access Object
public interface UserDAO {
	
	//declare the methods.
	
	//create new user
	
	public boolean save(User user);
	
	
	//update the existing user
	
	public boolean update(User user);
	
	
	//get the user details
	
	public   User     get(String emailID);
	
	
	//delete the user
	
	public   boolean    delete(String emailID);
	
	//to get all the users
	public List<User>   list();
	
	//validate whether the credentials are correct or not.
	
	public    User      validate(String emailID, String password);
	
	
	
	//we may require more methods...will discuss
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
