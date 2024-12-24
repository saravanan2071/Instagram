package com.model.interfaces;

interface CommentService{
	
	boolean add(Comment comment);
	
	boolean delete(int commentedUserId, int postId, int commentId);
	
	Collection<Comment> get(postId);
	
}