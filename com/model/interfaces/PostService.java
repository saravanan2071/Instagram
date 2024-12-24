package com.model.interfaces;

import java.util.Map;
import com.model.models.Post;
import com.model.models.User;

interface PostService{
	
	Post post(Post post, User user);
	
	boolean delete(int userId, int postId);
	
	boolean delete(int userId);
	
	Post get (int userId, int postId);
	
	Map<Integer, Post> get(int userId);
	
}