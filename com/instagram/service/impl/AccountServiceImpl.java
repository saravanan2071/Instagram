package com.instagram.service.impl;

import java.util.Map;

import com.instagram.model.User;
import com.instagram.service.AccountService;
import com.instagram.service.StorageService;
import com.instagram.service.UserValidator;

public class AccountServiceImpl implements AccountService {


    private StorageService storageService;
    private UserValidator userValidator;

    public AccountServiceImpl(StorageService storageService, UserValidator userValidator) {

        this.storageService = storageService;
        this.userValidator = userValidator;

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
			System.out.println("Account created successfully for userID: " + user.getUserID() + ".");
			user.setUserID();

		}

		else {

			System.err.println("Account creation failed. Invalid user data provided.");

		}

	}


	@Override
	public void deletUser(final int userID, final String password) {	

		if (userValidator.isUserExist(userID) && userValidator.getUserSession(userID)) {

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
    
}
