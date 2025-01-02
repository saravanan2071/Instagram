package com.instagram.service;

public interface UserValidator {
	
	boolean getUserSession(int userID);

    void setUserSession(int userID, boolean inout);

	boolean isUserExist(final int userID);
    
}
