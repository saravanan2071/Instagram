package com.model.models;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class Post{
	
	private int postId = 100;
	
	private User user;
	
	private String imageUrl;
	
	private String caption;
	
	private Set<Like> likes;
	
	private Map<Integer, Comment> comments;
	
	private LocalDate postedAt;
	
	public int getPostId(){
		return postId;
	}
	
	public void setPostId(){
		postId += 1;
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
	
	public void setLike(Like l){
		likes.add(l);
	}
	
	public Map<Integer, Comment> getComments(){
		return comments;
	}
	
	public void setComments(int commentId, Comment c){
		comments.put(commentId, c);
	}
	
	public LocalDate getPostedAt(){
		return postedAt;
	}
	
	public void setPostedAt(LocalDate postedAt){
		this.postedAt = postedAt;
	}
	
}