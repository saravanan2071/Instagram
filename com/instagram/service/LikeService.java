package com.instagram.service;

import java.util.Set;

import com.instagram.model.Like;
import com.instagram.model.Post;

public interface LikeService{

	void like(Like like);
	
	void dislike(Like like);
	
	Set<Like> get(Post post);
	
}