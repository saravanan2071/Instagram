package com.model.interfaces;

import com.model.models.Comment;
import com.model.models.Post;

public interface CommentService{
	
	void add(Comment comment);
	
	void delete(Comment comment);
	
	void get(Post post);
	
}