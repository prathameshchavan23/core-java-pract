package com.learm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.learn.config")
public class javaConfig {
	@Bean
	public Address getaddr(){
		return new Address();
	}
	
	@Bean
	public Student getStudent() {
		Student student = new Student();
		return student;
	}
	
	
}
