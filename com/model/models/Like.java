package com.model.models;

import java.time.LocalDate;

public  class Like{
	
	private int likeId;
	
	private int userId;
	
	private int postId;
	
	private LocalDate likedAt;
	
	public int getLikeId(){
		return likeId;
	}
	
	public void setLikeId(){
		
	}
	
	public int getUserId(){
		return userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getPostId(){
		return postId;
	}
	
	public void setPostId(int postId){
		this.postId = postId;
	}
	
	public LocalDate getLikedAt(){
		return likedAt;
	}
	
	public void setLikedAt(LocalDate likedAt){
		this.likedAt = likedAt;
	}
	
}