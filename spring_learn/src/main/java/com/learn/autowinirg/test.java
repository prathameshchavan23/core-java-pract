package com.learn.autowinirg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		
		  @SuppressWarnings("resource")
		  ApplicationContext context = new ClassPathXmlApplicationContext("com/learn/autowinirg/config.xml");
	        wiring wire = context.getBean("wiring", wiring.class);  // Fixed this line
	        System.out.println(wire);
	}
}
