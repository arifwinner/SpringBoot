package com.areef.springBootExample.springboot_demo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String helloWorld()
	{
		return "Hello";
	}
	
	/*
	 * @GetMapping(path = "/hello-world") public String helloWorld2() { return
	 * messageSource.getMessage("good.morning.message", null,
	 * LocaleContextHolder.getLocale()); }
	 */
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hellow World Bean");
	}
	
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hellow World %s", name));
	}
}
