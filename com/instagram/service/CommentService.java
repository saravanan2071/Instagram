package com.instagram.service;

import java.util.Map;

import com.instagram.model.Comment;
import com.instagram.model.Post;

public interface CommentService {
	
	void add(Comment comment);
	
	void delete(Comment comment);
	
	Map<Integer, Comment> get(Post post);
	
}