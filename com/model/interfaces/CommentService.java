package com.model.interfaces;

import java.util.Collection;

import com.model.models.Comment;

interface CommentService{
	
	boolean add(Comment comment);
	
	boolean delete(int commentedUserId, int postId, int commentId);
	
	Collection<Comment> get(int postId);
	
}