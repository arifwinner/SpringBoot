package com.areef.springBootExample.springboot_demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	
	//Example for URI version
	@GetMapping("v1/person")
	public Person1 personv1() {
		return new Person1("Bob");
	}
	
	//Example for URI version
	@GetMapping("v2/person")
	public Person2 personv2() {
		return new Person2(new Name("Md", "Areef"));
	}
	
	//Request Parameter versioning
	@GetMapping(value = "person/param", params = "version=1")
	public Person1 paramv2() {
		return new Person1("Bob");
	}
	//Request Parameter versioning
	@GetMapping(value = "person/param", params = "version=2")
	public Person2 paramv1() {
		return new Person2(new Name("Md", "Areef"));
	}
	
	//Header versionig 
	@GetMapping(value = "person/header", headers = "X-API-VERSION=1")
	public Person1 headerv1() {
		return new Person1("Bob");
	}
	
	//Header versionig 
	@GetMapping(value = "person/header", headers = "X-API-VERSION=2")
	public Person2 headerv2() {
		return new Person2(new Name("Md", "Areef"));
	}
	
	
	//Accept header / MIME type versioning 	
	@GetMapping(value = "person/produces", produces = "application/md.company.appv1+json")
	public Person1 producesv1() {
		return new Person1("Bob");
	}
	
	//Accept header / MIME type versioning 
	@GetMapping(value = "person/produces", produces = "application/md.company.appv2+json")
	public Person2 producesv2() {
		return new Person2(new Name("Md", "Areef"));
	}
}
