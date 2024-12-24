package com.model.models;

import java.time.LocalDate;

public class Comment{
	
		private int commentId;
		
		private int commenterId;
		
		private int postId;
		
		private String comment;
		
		private LocalDate commentedAt;
		
		public int getCommentId(){
			return commentId;
		}
		
		public void setCommentId(){
			
		}
		
		public int getCommenterId(){
			return commenterId;
		}
		
		public void setCommenterId(int commenterId){
			this.commenterId = commenterId;
		}

		public int getPostId(){
			return postId;
		}
		
		public void setPostId(int postId){
			this.postId = postId;
		}
		
		public String getComment(){
			return comment;
		}
		
		public void setComment(String comment){
			this.comment = comment;
		}
		
		public LocalDate geCommentedAt(){
			return commentedAt;
		}
		
		public void setCommentdAt(LocalDate commentedAt){
			this.commentedAt = commentedAt;
		}
		
}