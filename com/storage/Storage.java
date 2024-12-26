package com.storage;

import java.util.Map;
import com.model.models.User;

public interface Storage {
	
	Map<Integer, User> get();
	
	void set(Integer uid, User u);
		
}
