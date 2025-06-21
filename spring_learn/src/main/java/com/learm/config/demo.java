package com.learm.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class demo {

	public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(javaConfig.class);
        Student stud = context.getBean("getStudent", Student.class);
        System.out.println(stud);
	}

}
