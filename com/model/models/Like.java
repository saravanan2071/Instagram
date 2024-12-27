package com.model.models;

import java.time.LocalDateTime;

public  class Like{

	private static int likeCounter = 100;

	private final int likeId;
	
	private String userName;

	private String pUserName;

	private Post post;

	private Integer postId;
	
	private LocalDateTime likedAt;
	
	public Like(String userName, String pUserName, Integer postId) {
		likeId = likeCounter++;
		this.userName = userName;
		this.pUserName = pUserName;
		this.postId = postId;
		this.likedAt = LocalDateTime.now();
	}
	
	public int getLikeId(){
		return likeId;
	}

	public String getUserName(){
		return userName;
	}

	public String getPostUserName(){
		return pUserName;
	}
	
	public Integer getPostId(){
		return postId;
	}
	
	public LocalDateTime getLikedAt(){
		return likedAt;
	}
	
	public int getLikesCount(){
		return post.getLikes().size();
	}

	
	public String toString() {
		return " Username : "+ userName +", LikeId" + likeId + ", LikedAt : "+likedAt+"\n";
	}

}