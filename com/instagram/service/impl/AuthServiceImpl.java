package com.instagram.service.impl;

import com.instagram.model.User;
import com.instagram.service.AuthService;
import com.instagram.service.StorageService;
import com.instagram.service.UserValidator;

public class AuthServiceImpl implements AuthService{

    private UserValidator userValidator;
    private StorageService storageService;

    public AuthServiceImpl(UserValidator userValidator, StorageService storageService){

        this.userValidator = userValidator;
        this.storageService = storageService;

    }

    @Override
	public void login(final int userID, final String password) {

		if (userValidator.getUserSession(userID)) {

			System.out.println("You are already logged in");
			return;		

		}
		
		if (userValidator.isUserExist(userID) && password != null) {
			
			final User user = storageService.get(userID);

			if (user.getPassword().equals(password)) {

				System.out.println("Login successfull");
				System.out.println("-----------------");
				System.out.println(storageService.get(userID));
				System.out.println();
					
				// update the usersession is true to access the other features
				userValidator.setUserSession(userID, true);

			}

			else {

				System.out.println("Invalid credentials. Please check your userID and password.");

				// update the usersession is false to avoid access to other features, when the credentials are Invalid
				userValidator.setUserSession(userID, false);

			}
		}

		else {

			System.out.println("user does not exist...");

		}
		
	}

	@Override
	public void logout(final int userID, final String password) {

		if (userValidator.getUserSession(userID)) {

			userValidator.setUserSession(userID, false);
			System.out.println("Logout successful. See you again, " + userID + "!");

		}

		else {

			System.out.println("You are already logged out, " + userID + ".");

		}
	}
    
}
