package com.storage;

import java.util.*;
import com.model.models.User;

public class Storage implements StorageInterface{


	//private static Map<Integer, User> users = new HashMap<>();
	
	
	public Map<Integer, User> get() 
	{
		
		return users;
	}
	
	
	public Map<Integer, User> getAllUsers() 
	{
		
		return users;
	}
	
	
	public void set(Integer uid, User u) 
	{
        users.put(uid, u);
	}
	
	
	
//	public Integer get(String userName) {
//	
//		for(Entry<Integer, User> e : users.entrySet()) {
//		
//			if(e.getValue().getName().equals(userName)) {
//			
//				return e.getKey();
//			}
//		}
//	
//		return 0;
//	}
	
}
