package com.areef.springBootExample.springboot_demo.user;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import com.areef.springBootExample.springboot_demo.post.Posts;

public class User {

	public Integer id;
	@Size(min = 2, message = "Name should contains more than 2 characters")
	public String name;
	public Date dob;
	public List<Posts> posts;

	public User() {
		super();
	}

	public User(Integer id, String name, Date dob, List<Posts> posts) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.posts = posts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

}
