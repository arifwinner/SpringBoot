package com.areef.springBootExample.springboot_demo.user;


import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.areef.springBootExample.springboot_demo.*"})
@EnableSwagger2
public class SpringbootDemoApplicationDemo {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplicationDemo.class, args);
	}
	
	@Bean
	public LocaleResolver locareResolver() {
		//SessionLocaleResolver localeResolver = new  SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
}
