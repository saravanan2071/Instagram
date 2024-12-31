package com.instagram.model;

import java.time.LocalDateTime;

public  class Like{

	private static int likeIDCounter = 100;

	private final int likeId;
	
	private int likerUserID;

	private int uploaderUserID;

	private Post post;

	private int postId;
	
	private LocalDateTime likedAt;
	
	public Like(int uploaderUserID,int likerUserID, int postId) {
		likeId = likeIDCounter++;
		this.likerUserID = likerUserID;
		this.uploaderUserID = uploaderUserID;
		this.postId = postId;
		this.likedAt = LocalDateTime.now();
	}
	
	public int getLikeId(){
		return likeId;
	}

	public int getLikerUserID(){
		return likerUserID;
	}

	public int getUploaderUserID(){
		return uploaderUserID;
	}
	
	public int getPostId(){
		return postId;
	}
	
	public LocalDateTime getLikedAt(){
		return likedAt;
	}
	

	public int getLikesCount(){
		return post.getLikes().size();
	}

	
	public String toString() {
		return " likerUsername : "+ likerUserID +", LikeId" + likeId + ", LikedAt : "+likedAt+"\n";
	}

}