package com.instagram.service;

import java.util.Map.Entry;
import java.util.Set;

import com.instagram.model.User;

public interface StorageService {
	
	User get(Integer userID);

	Set<Entry<Integer, User>> get();
	
	void set(Integer userID, User user);

	void delete(Integer userID);
			
}
