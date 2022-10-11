package com.coderscampus.dto;

public class CommentDto {
	
	
	private String commentDetails;
	private Long userId;
	private Long taskId;
	
	public String getCommentDetails() {
		return commentDetails;
	}
	public void setCommentDetails(String commentDetails) {
		this.commentDetails = commentDetails;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setPostId(Long taskId) {
		this.taskId = taskId;
	}
	
	
	
}
