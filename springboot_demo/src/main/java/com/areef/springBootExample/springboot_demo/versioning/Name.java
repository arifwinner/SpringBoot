package com.areef.springBootExample.springboot_demo.versioning;

public class Name {

	String firstNmae;
	String lastName;
	
	
	public Name() {
		super();
	}
	public Name(String firstNmae, String lastName) {
		super();
		this.firstNmae = firstNmae;
		this.lastName = lastName;
	}
	public String getFirstNmae() {
		return firstNmae;
	}
	public void setFirstNmae(String firstNmae) {
		this.firstNmae = firstNmae;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
