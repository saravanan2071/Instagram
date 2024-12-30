package com.instagram.service.impl;

import java.util.Map;
import java.util.HashMap;

import com.instagram.model.User;
import com.instagram.service.StorageService;
import com.instagram.service.UserService;

public class UserServiceImpl implements UserService{

	private StorageService storageService;
	private static Map<String, Boolean> userSession;
	private Integer userID;
	
	public UserServiceImpl(StorageService storageService)
	{
		this.storageService = storageService;
		userSession = new HashMap<>();
	}
	
	// Logic for User Login 
	@Override
	public void login(final String userName, final String password) {
		
			// checking whether the username and password is not null
			if(userName != null && password != null)
			{
				final Integer userId = getUserId(userName);
				final User user = storageService.get(userId);

				if (user!= null && user.getUserName().equals(userName) && user.getPassword().equals(password)) 
				{
					System.out.println("Login successfull");
					System.out.println("-----------------");
					System.out.println(storageService.get(userId));
					System.out.println();
					
					// update the usersession is true to access the other features
					userSession.put(userName, true);
				}
				else 
				{
					System.out.println("Invalid credentials. Please check your username and password.");

					// update the usersession is false to avoid access to other features, when the credentials are Invalid
					userSession.put(userName, false);
				}
			}
		
	}

	@Override
	public void logout(final String userName, final String password)
	{
		if (getUserSession(userName))
		{
			userSession.put(userName, false);	
			System.out.println("Logout successful. See you again, " + userName + "!");
		}
		else{
			System.out.println("You are already logged out, " + userName + ".");
		}
	}
	
	// Logic for Create a new Account 
	@Override
	public void createAccount(final User user) 
	{
		boolean isEqual = false;

		for(final Map.Entry<Integer, User> entry : storageService.get())
		{
			if (user.equals(entry.getValue())) 
			{
				System.out.println("Account creation failed. A user with the same details already exists.");
				isEqual = true;
				return;	
			}
		}

		if (user != null || !isEqual) 
		{
			userID = user.getUserName().hashCode() + user.getEmail().hashCode();
			storageService.set(userID, user);
			userID++;
			System.out.println("Account created successfully for username: " + user.getUserName() + ".");
		}
		else
		{
			System.err.println("Account creation failed. Invalid user data provided.");
		}

	}

	// Logic for Delete Account 
	@Override
	public void deletUser(String userName, String password) 
	{	

		String un = "";
		String pswd = "";
		Integer k = 0;

		//  check the usersession	
		if(getUserSession(userName)){
            for(Map.Entry<Integer, User> e : storageService.get()) 
		    {
			    User u = e.getValue();
			
			    if(u.getUserName().equals(userName) && u.getPassword().equals(password))
			    {   

                    un = u.getUserName();
                    pswd = u.getPassword();
                    k = e.getKey();
			    }
		    }
			
			// validate the credentials
            if(un.equals(userName) && pswd.equals(password)) 
            {
                storageService.delete(k);
                System.out.println("Account deleted successfully for username: " + un + ".");
            }

            else 
            {
                System.out.println("Account deletion failed. Invalid username or password.");
            }
        }

        else
        {
            System.out.println("Account deletion failed. You are not logged in, " + userName + ".");
        }
		
	}

	// Logic for Tracking User Session
	@Override
	public boolean getUserSession(String userName)
	{	
		return userSession.getOrDefault(userName, false);
	}


	// to the user using username
	public User getUser(String userName)
	{
		User user = null;

		for(final Map.Entry<Integer, User> entry : storageService.get())
		{
			User user1 = entry.getValue();
			if(user.getUserName().equals(userName))
			{
				user =  user1;
			}
		}

		return user;
	}


	// to get the userID using username
	public Integer getUserId(String userName)
	{
		Integer userId = null;
		for(final Map.Entry<Integer, User> entry : storageService.get())
		{
			User user = entry.getValue();
			if(user.getUserName().equals(userName))
			{
				userId = entry.getKey();
			}
		}
		return userId;
	}

}