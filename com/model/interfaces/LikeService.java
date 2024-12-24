package com.model.interfaces;

import java.util.Set;

import com.model.models.Like;

interface LikeService{

	void like(int userId, int postId);
	
	void dislike(int userId, int postId);
	
	Set<Like> get();
	
}