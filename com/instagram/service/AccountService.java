package com.instagram.service;

import com.instagram.model.User;

public interface AccountService {
	
	void createAccount(User user);
	
	void deletUser(int userID, String password);
    
}
