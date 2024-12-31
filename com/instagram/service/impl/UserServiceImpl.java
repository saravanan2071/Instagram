package com.instagram.service.impl;

import java.util.Map;
import java.util.HashMap;

import com.instagram.model.User;
import com.instagram.service.StorageService;
import com.instagram.service.UserService;

public class UserServiceImpl implements UserService {

	private StorageService storageService;
	private static Map<Integer, Boolean> userSession;
	
	public UserServiceImpl(StorageService storageService) {

		this.storageService = storageService;
		userSession = new HashMap<>();

	}
	

	@Override
	public void login(final int userID, final String password) {

		if (getUserSession(userID)) {

			System.out.println("You are already logged in");
			return;		

		}
		
		if (isUserExist(userID) && password != null) {
			
			final User user = storageService.get(userID);

			if (user.getPassword().equals(password)) {

				System.out.println("Login successfull");
				System.out.println("-----------------");
				System.out.println(storageService.get(userID));
				System.out.println();
					
				// update the usersession is true to access the other features
				userSession.put(userID, true);

			}

			else {

				System.out.println("Invalid credentials. Please check your userID and password.");

				// update the usersession is false to avoid access to other features, when the credentials are Invalid
				userSession.put(userID, false);

			}
		}

		else {

			System.out.println("user does not exist...");

		}
		
	}

	@Override
	public void logout(final int userID, final String password) {

		if (getUserSession(userID)) {

			userSession.put(userID, false);	
			System.out.println("Logout successful. See you again, " + userID + "!");

		}

		else {

			System.out.println("You are already logged out, " + userID + ".");

		}
	}
	
	
	@Override
	public void createAccount(final User user) {

		boolean isEqual = false;

		// iterate through the Users map to check the dupilcate user details
		for (final Map.Entry<Integer, User> entry : storageService.get()) {

			if (user.equals(entry.getValue())) {

				System.out.println("Account creation failed. A user with the same details already exists.");
				isEqual = true;
				return;	

			}
		}

		if (user != null || !isEqual) {
			
			storageService.set(user.getUserID(), user);
			user.setUserID();
			System.out.println("Account created successfully for userID: " + user.getUserID() + ".");

		}

		else {

			System.err.println("Account creation failed. Invalid user data provided.");

		}

	}


	@Override
	public void deletUser(final int userID, final String password) {	

		if (isUserExist(userID) && getUserSession(userID)) {

			final User user = storageService.get(userID);
			
			if (user.getPassword().equals(password)) {

				storageService.delete(userID);
                System.out.println("Account deleted successfully for userID: " + userID + ".");

			}

			else {
				System.out.println("Account deletion failed. Invalid password.");

			}
		}

        else {
            System.out.println("Account deletion failed. You are not logged in or user does not exist, " + userID + ".");
        
		}
		
	}

	// for track User Session
	@Override
	public boolean getUserSession(final int userID) {

		return userSession.getOrDefault(userID, false);

	}
	
    // for check the existence of an user
	@Override
    public boolean isUserExist(final int userID) {

        return storageService.getUsers().containsKey(userID);
		
    }
	
}