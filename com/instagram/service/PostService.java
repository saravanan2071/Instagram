package com.instagram.service;

import java.util.Map;

import com.instagram.model.Post;

public interface PostService {
	
	void post(Post post);
	
	void delete(Post post);
	
	void delete(int userID);
	
	Map<Integer, Post> get(int userID);
	
}