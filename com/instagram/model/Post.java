package com.instagram.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Post{

	private static int postCounter = 100;

	private final int postId;
	
	private String userName;
	
	private String imageUrl;

	private String caption;
	
	private Set<Like> likes;
	
	private Map<Integer, Comment> comments;
	
	private LocalDateTime postedAt;
	
	public Post(String userName, String imageUrl, String caption) {
		this.userName = userName;
		this.imageUrl = imageUrl;
		this.caption = caption;
		likes = new HashSet<>(); 
		comments = new HashMap<>();
		this.postedAt = LocalDateTime.now();
		postId = postCounter++;
	}
	
	public int getPostId(){
		return postId;
	}
	
	public String getImageUrl(){
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl){
		this.imageUrl =  imageUrl;
	}
	
	public String getCaption(){
		return caption;
	}
	
	public void setCaption(String caption){
		this.caption = caption;
	}
	
	public Set<Like> getLikes(){
		return likes;
	}
	
	public void setLike(Like like){
		likes.add(like);
	}

	public int getLikesCount(){
		return likes.size();
	}
	
	public Map<Integer, Comment> getComments(){
		return comments;
	}
	
	public void setComments(Integer commentId, Comment c){
		comments.put(commentId, c);
	}
	
	public LocalDateTime getPostedAt(){
		return postedAt;
	}
	
	public String getUserName(){
		return userName;
	}

	public String toString() {
		return "\n userName: " + userName + "\n image: " + imageUrl + "\n caption : " + caption + "\n likes : " + likes.size()
				+ "\n comments: " + comments.size() + "\n postedAt: " + postedAt + "\n postID: " + getPostId() + "\n" + "\n";
	}
}