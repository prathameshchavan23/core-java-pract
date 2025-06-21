package com.spring.spring_learn;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml")) {
			Student student1 = (Student) context.getBean("student1");
			System.out.println(student1);
		}
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
//		System.out.println(loader.getResource("config.xml"));

	}
}
