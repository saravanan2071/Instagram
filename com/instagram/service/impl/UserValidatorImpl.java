package com.instagram.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.instagram.service.StorageService;
import com.instagram.service.UserValidator;

public class UserValidatorImpl implements UserValidator{
    
	private static Map<Integer, Boolean> userSession;
    private StorageService storageService;

    public UserValidatorImpl(StorageService storageService){

        userSession = new HashMap<>();
        this.storageService = storageService;
    }
    
	// for track User Session
	@Override
	public boolean getUserSession(final int userID) {

		return userSession.getOrDefault(userID, false);

	}

    @Override
    public void setUserSession(final int userID, boolean inout) {

        userSession.put(userID, inout);

    }
	
    // for check the existence of an user
	@Override
    public boolean isUserExist(final int userID) {

        return storageService.getUsers().containsKey(userID);
		
    }
	
}
