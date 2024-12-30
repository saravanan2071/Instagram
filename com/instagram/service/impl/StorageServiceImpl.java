package com.instagram.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import com.instagram.model.User;
import com.instagram.service.StorageService;

public class StorageServiceImpl implements StorageService{

	public static Map<Integer, User> users = new HashMap<>();

	@Override
	public User get(Integer userID) 
	{		
		return users.get(userID);
	}

	@Override
	public Set<Entry<Integer, User>> get()
	{
		return users.entrySet();
	}
	
	@Override
	public void set(Integer userID, User u)
	{
		users.put(userID, u);
	}

	@Override
	public void delete(Integer userID)
	{
		users.remove(userID);
	}

}