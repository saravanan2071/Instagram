package com.model.interfaces;

interface LikeService{

	void like(int userId, int postId);
	
	void dislike(int userId, int postId);
	
	Set<Like> get();
	
}