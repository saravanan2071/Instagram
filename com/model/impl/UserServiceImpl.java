package com.model.impl;

import java.util.*;
import java.util.Map.Entry;
import com.model.interfaces.UserService;
import com.model.models.User;
import com.storage.Storage;
import com.storage.StorageImpl;

public class UserServiceImpl implements UserService{

	private static Integer userID = 10001;
	private Storage db = new StorageImpl();
	private static Map<String, Boolean> userSession = new HashMap<>();
	
	
	// Logic for User Login 
	public void login(String userName, String password) {
		
			// checking whether the username and password is not null
			if(userName != null && password != null)
			{
				String un="";
				String pswd="";
				Integer k=0;
			
				// fethching the user data's with help of username to check the credentials
				for(Map.Entry<Integer, User> e : db.get().entrySet()) 
				{
					User u = e.getValue();
					if(u.getUserName().equals(userName) && u.getPassword().equals(password)) 
					{
						un = u.getUserName();
						pswd = u.getPassword();
						k = e.getKey();
					}
				}
				
				// check the credentials
				if(un.equals(userName) && pswd.equals(password)) 
				{
					System.out.println("Login successfull");
					System.out.println("-----------------");
					System.out.println(db.get().get(k));
					System.out.println();
					
					// update the usersession is true to access the other features
					userSession.put(userName, true);
				}
				
				else 
				{
					System.out.println("Inavlid credentials");

					// update the usersession is false to avoid access to other features, when the credentials are Invalid
					userSession.put(userName, false);
				}
			}
		
	}
	
	// Logic for Create a new Account 
	public void createAccount(User user) 
	{
        boolean isEqual = false;

		// to store the user directly when the DB is empty
        if(Storage.users.isEmpty()){
            db.set(userID, user);
			userID++;
			System.out.println(user.getUserName() + ", Account created successfully...");

			// reinitialize to true, for avoid the dublicate data
            isEqual = true;
        }
        
        else{

			// check the user whether the user details are already exist
            for(Entry<Integer, User> existing: db.get().entrySet()){

                User u = existing.getValue();

                if(user.equals(u)){

                    System.out.println("the user is already exist");
                    isEqual = true; // reinitialize to true, for avoid the dublicate data
                    break;
                }
            }
        }

		// add the user when the above two conditions are satisfied
		if(isEqual==false) 
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
			
		if(getUserSession(userName)){
            for(Map.Entry<Integer, User> e : db.get().entrySet()) 
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

        else
        {
            System.out.println(userName +" you are not loggedin");
        }
		
	}

	// Logic for Tracking User Session
	public boolean getUserSession(String userName)
	{	
		return userSession.get(userName);
	}

}