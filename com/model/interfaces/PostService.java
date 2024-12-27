package com.model.interfaces;

import java.util.Map;

import com.model.models.Post;

public interface PostService{
	
	void post(Post post);
	
	void delete(String userName, Integer postId);
	
	void delete(String userName);
	
	Map<Integer, Post> get(String userName);
	
}