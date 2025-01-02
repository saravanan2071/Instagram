package com.instagram.service;

public interface AuthService {
	
	void login(int userID, String password);
	
	void logout(int userID, String password);
    
}
