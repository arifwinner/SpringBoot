package com.areef.springBootExample.springboot_demo.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.areef.springBootExample.springboot_demo.post.Posts;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User application Demo")
@Entity
public class User {

	@Id
	@GeneratedValue
	public Integer id;
	
	@ApiModelProperty(notes = "Name should contains atleast 2 characters")
	@Size(min = 2, message = "Name should contains more than 2 characters")
	public String name;
	
	@ApiModelProperty(notes = "Birthday should not be future date")
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
