package com.instagram.model;

import java.time.LocalDateTime;

public class Comment{

		// cmnt = comment

		private static int cmntCounter = 200;

		private final int cmntId;
		
		private int postId;

		private int postedUserID;
		
		private int commentedUserID;
		
		private String cmnt;
		
		private LocalDateTime commentedAt;
		
		public Comment(int postId, int postedUserID, int commentedUserID, String cmnt) {
			this.cmntId = cmntCounter++;
			this.postId = postId;
			this.postedUserID = postedUserID;
			this.commentedUserID = commentedUserID;
			this.cmnt = cmnt;
			this.commentedAt = LocalDateTime.now();
		}

		public int getCommentId(){
			return cmntId;
		}

		public int getPostedUserID(){
			return postedUserID;
		}
		
		public int getCmntUserID(){
			return commentedUserID;
		}

		public int getPostId(){
			return postId;
		}
		
		public String getComment(){
			return cmnt;
		}
		
		public LocalDateTime geCommentedAt(){
			return commentedAt;
		}

		public String toString() {
			return commentedUserID + "\n  " + cmnt;
		}
		
}