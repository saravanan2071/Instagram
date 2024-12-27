package com.model.models;

import java.time.LocalDateTime;

public class Comment{

		// cmnt = comment

		private static Integer cmntCounter = 200;

		private final Integer cmntId;
		
		private Integer postId;

		private String postedUserName;
		
		private String cmntUserName;
		
		private String cmnt;
		
		private LocalDateTime commentedAt;
		
		public Comment(Integer postId, String postedUserName, String cmntUserName, String cmnt) {
			this.cmntId = cmntCounter++;
			this.postId = postId;
			this.postedUserName = postedUserName;
			this.cmntUserName = cmntUserName;
			this.cmnt = cmnt;
			this.commentedAt = LocalDateTime.now();
		}

		public Integer getCommentId(){
			return cmntId;
		}

		public String getpostedUserName(){
			return postedUserName;
		}
		
		public String getCmntUserName(){
			return cmntUserName;
		}

		public Integer getPostId(){
			return postId;
		}
		
		public String getComment(){
			return cmnt;
		}
		
		public LocalDateTime geCommentedAt(){
			return commentedAt;
		}

		public String toString() {
			return cmntUserName + "\n  " + cmnt;
		}
		
}