package com.model.models;

public  class Like{
	
	private int likeId;
	
	private int userId;
	
	private int postId;
	
	private Date likedAt;
	
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
	
	public Date getLikedAt(){
		return likedAt;
	}
	
	public void setLikedAt(Date likedAt){
		this.likedAt = likedAt;
	}
	
}