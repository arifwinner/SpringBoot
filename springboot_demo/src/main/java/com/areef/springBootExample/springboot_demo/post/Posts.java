package com.areef.springBootExample.springboot_demo.post;

public class Posts {
	
	private int postId;
	private String message;
	
	public Posts(int postId, String message) {
		super();
		this.postId = postId;
		this.message = message;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
