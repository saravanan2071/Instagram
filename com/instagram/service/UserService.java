package com.instagram.service;
import com.instagram.model.User;

public interface UserService{
	
	void login(String userName, String password);
	
	void logout(String userName, String password);
	
	void createAccount(User user);
	
	void deletUser(String userName, String password);
	
	boolean getUserSession(String userName);
	
}