package com.storage;

import java.util.HashMap;
import java.util.Map;

import com.model.models.User;

public interface StorageInterface {
	
	Map<Integer, User> users = new HashMap<>();
	
	Map<Integer, User> get();
	
	Map<Integer, User> getAllUsers();
	
	void set(Integer uid, User u);
		
}
