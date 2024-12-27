package com.model.interfaces;

import java.util.Set;

import com.model.models.Like;
import com.model.models.Post;

public interface LikeService{

	void like(Like like);
	
	void dislike(Like like);
	
	void get(Post post);
	
}