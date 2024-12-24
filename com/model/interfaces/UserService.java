package com.model.interfaces;
import com.model.models.User;

public interface UserService{
	
	void login(String userName, String password);
	
	void createAccount(User user);
	
	void deletUser(String userName, String password);
	
	boolean getUserSession(String userName);
	
}