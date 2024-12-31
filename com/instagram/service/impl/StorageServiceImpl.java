package com.instagram.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import com.instagram.model.User;
import com.instagram.service.StorageService;

public class StorageServiceImpl implements StorageService {

	private static Map<Integer, User> users = new HashMap<>();

	@Override
	public User get(final int userID) {

		return users.get(userID);

	}

	@Override
	public Set<Entry<Integer, User>> get() {

		return users.entrySet();
	
	}
	
	@Override
	public void set(final int userID, final User u) {

		users.put(userID, u);
	
	}

	@Override
	public void delete(final int userID) {

		users.remove(userID);
	
	}

	@Override
	public Map<Integer, User> getUsers() {
		
		return users;
	
	}

}