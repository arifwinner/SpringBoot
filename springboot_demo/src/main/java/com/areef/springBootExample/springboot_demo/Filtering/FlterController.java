package com.areef.springBootExample.springboot_demo.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlterController {
	
	@GetMapping("/filtering")
	public SomeBean retriveSomeBean() {
		return new SomeBean("Arif", "007","pasword");
	}
	

	@GetMapping("/filterings")
	public List<SomeBean> listSomeBean() {
		return Arrays.asList(new SomeBean("Arif", "007","pasword"),new SomeBean("Arif2", "0072","pasword2"));
	}

}
