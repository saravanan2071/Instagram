package com.storage;

import java.util.*;
import com.model.models.User;

public class StorageImpl implements Storage{

	public static Map<Integer, User> users = new HashMap<>();

	public Map<Integer, User> get() 
	{		
		return users;
	}
	
	public void set(Integer uid, User u) 
	{
		users.put(uid, u);
	}
	
}
