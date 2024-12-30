package com.instagram.service;

import com.instagram.model.Comment;
import com.instagram.model.Post;

public interface CommentService{
	
	void add(Comment comment);
	
	void delete(Comment comment);
	
	void get(Post post);
	
}