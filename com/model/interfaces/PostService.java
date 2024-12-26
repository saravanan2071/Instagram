package com.model.interfaces;

import java.util.List;
import com.model.models.Post;
//import com.model.models.User;

public interface PostService{
	
	void post(Post post);
	
	boolean delete(int userId, int postId);
	
	boolean delete(int userId);
	
	Post get (int userId, int postId);
	
	void get(String userName);
	
}