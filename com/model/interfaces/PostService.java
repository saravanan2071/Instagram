package com.model.interfaces;

interface PostService{
	
	Post post(Post post, User user);
	
	boolean delete(int userId, int postId);
	
	boolean delete(int userId);
	
	Post get (int userId, int postId);
	
	Map<Integer, Post> get(int userId);
	
}