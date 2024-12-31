package com.instagram.service;
import com.instagram.model.User;

public interface UserService {
	
	void login(int userID, String password);
	
	void logout(int userID, String password);
	
	void createAccount(User user);
	
	void deletUser(int userID, String password);
	
	boolean getUserSession(int userID);

	boolean isUserExist(final int userID);
	
}