package com.model.impl;
import java.util.*;

import com.model.interfaces.UserService;
import com.model.models.User;
import com.storage.Storage;
import com.storage.StorageInterface;
public class UserServiceImpl implements UserService{

	private static Integer userID = 10001;
	private StorageInterface db = new Storage();
	//private Map<String, Boolean> userSession = new HashMap<>();
	
	
	// Logic for User Login 
	public void login(String userName, String password) {
		
			String un="";
			String pswd="";
			Integer k=0;
			
			for(Map.Entry<Integer, User> e : db.getAllUsers().entrySet()) 
			{
				User u = e.getValue();
				if(u.getUserName().equals(userName) && u.getPassword().equals(password)) 
				{
					un = u.getUserName();
					pswd = u.getPassword();
					k = e.getKey();
				}
			}
			
			if(un.equals(userName) && pswd.equals(password)) 
			{
				System.out.println("Login successfull");
				System.out.println("-----------------");
				System.out.println(db.get().get(k));
				System.out.println();
			}
			
			else 
			{
				System.out.println("Inavlid credentials");
			}
		
	}
	
	// Logic for Create a new Account 
	public void createAccount(User user) 
	{
		if(user.getName()==null || user.getPassword()==null || user.getEmail()==null || user.getUserName()==null) 
		{
			System.out.println("The name, password, email, and username fields must not be left empty.");
		}
		else 
		{
			db.set(userID, user);
			userID++;
			System.out.println(user.getUserName() + ", Account created successfully...");
		}
	}

	// Logic for Delete Account 
	public void deletUser(String userName, String password) 
	{	

		String un = "";
		String pswd = "";
		Integer k = 0;
			
		for(Map.Entry<Integer, User> e : db.getAllUsers().entrySet()) 
		{
			User u = e.getValue();
			
			if(u.getUserName().equals(userName) && u.getPassword().equals(password))
			{

				un = u.getUserName();
				pswd = u.getPassword();
				k = e.getKey();
			}
		}
			
		if(un.equals(userName) && pswd.equals(password)) 
		{
			db.get().remove(k);
			System.out.println(un + " instagram account deleted...");
		}
		else 
		{
			System.out.println("Invalid credentials");
		}
		
	}

	// Logic for Tracking User Session
	public boolean getUserSession(String userName) 
	{	
		return false;
	}

}
