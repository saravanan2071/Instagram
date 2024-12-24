package com.model.interfaces;

interface UserService{
	
	User login(String userName, String password);
	
	User createAccount(User user);
	
	boolean deletUser(String userName, int userId, String password);
	
	boolean getUserSession(String userName);
	
}