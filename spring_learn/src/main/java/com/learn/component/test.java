package com.learn.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext con = new ClassPathXmlApplicationContext("com/learn/component/config.xml");
		Student stud = con.getBean("ob", Student.class);
		System.out.println(stud);
		System.out.println(stud.getAddress());
		System.out.println(stud.getAddress().getClass().getName());

		System.out.println(stud.hashCode());
		// by default it's singleton scope so value of both Hash-code will be same
		Student stud2 = con.getBean("ob", Student.class);
		// After @Scope("prototype") you'll get different hash-code
		System.out.println(stud2.hashCode());
	}

}
