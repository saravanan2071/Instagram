package com.model.models;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
//import com.model.models.User;

public class Post{

	private static int postId = 100;
	
	private String userName;
	
	private String imageUrl;

	private String caption;
	
	private Set<Like> likes;
	
	private Map<Integer, Comment> comments;
	
	private LocalDateTime postedAt;
	
	public Post(String userName, String imageUrl, String caption, LocalDateTime postedAt) {
		this.userName = userName;
		this.imageUrl = imageUrl;
		this.caption = caption;
		this.postedAt = postedAt;
		postId++;
	}
	
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
	
	public LocalDateTime getPostedAt(){
		return postedAt;
	}
	
	public void setPostedAt(LocalDateTime postedAt){
		this.postedAt = postedAt;
	}
	
	public String getUserName(){
		return userName;
	}

	public String toString() {
		return "Post" + "\n userName: " + userName + "\n image: " + imageUrl + "\n caption : " + caption + "\n likes : " + likes
				+ "\n comments: " + comments + "\n postedAt: " + postedAt + "\n postID: " + postId;
	}
}