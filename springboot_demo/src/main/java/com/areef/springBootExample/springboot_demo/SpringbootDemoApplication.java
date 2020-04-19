package com.areef.springBootExample.springboot_demo;

import java.util.Locale;

import javax.websocket.Session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

//@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Bean
	public LocaleResolver locareResolver() {
		//SessionLocaleResolver localeResolver = new  SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	/*
	 * Instead of this configuration we can add one property sppring.messages.basename to application.property file
	 * @Bean public ResourceBundleMessageSource bundleMessageSource() {
	 * 
	 * ResourceBundleMessageSource messageSource = new
	 * ResourceBundleMessageSource(); messageSource.setBasename("messages"); return
	 * messageSource;
	 * 
	 * }
	 */
}
