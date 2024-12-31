package com.instagram.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.instagram.model.User;

public interface StorageService {
	
	User get(int userID);

	Set<Entry<Integer, User>> get();
	
	void set(int userID, User user);

	void delete(int userID);

	Map<Integer, User> getUsers();
			
}
