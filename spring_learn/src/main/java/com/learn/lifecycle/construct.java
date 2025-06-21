package com.learn.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class construct {

	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "construct [subject=" + subject + "]";
	}

	public construct() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	@PostConstruct
	public void starting() {
		System.out.println("Starting method");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("Ending method");
	}
}
