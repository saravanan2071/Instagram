package com.instagram.model;

import java.time.LocalDateTime;

public  class Like{

	private static int likeCounter = 100;

	private final int likeId;
	
	private String likerUsername;

	private String uploaderUsername;

	private Post post;

	private Integer postId;
	
	private LocalDateTime likedAt;
	
	public Like(String likerUsername, String uploaderUsername, Integer postId) {
		likeId = likeCounter++;
		this.likerUsername = likerUsername;
		this.uploaderUsername = uploaderUsername;
		this.postId = postId;
		this.likedAt = LocalDateTime.now();
	}
	
	public int getLikeId(){
		return likeId;
	}

	public String getUserName(){
		return likerUsername;
	}

	public String getPostUserName(){
		return uploaderUsername;
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
		return " likerUsername : "+ likerUsername +", LikeId" + likeId + ", LikedAt : "+likedAt+"\n";
	}

}