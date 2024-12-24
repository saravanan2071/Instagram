package com.model.models;

public class Post{
	
	private int postId;
	
	private User user;
	
	private String imageUrl;
	
	private String caption;
	
	private Set<Like> likes;
	
	private Map<Integer, Comment> comments;
	
	private Date postedAt;
	
	public int getPostId(){
		return postId;
	}
	
	public void setPostId(){
		this.postId = user.post.size()+1;
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
		this.caption = caption:
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
	
	public Date getPostedAt(){
		return postedAt;
	}
	
	public void setPostedAt(Date postedAt){
		this.postedAt = postedAt;
	}
	
}