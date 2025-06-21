package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
	public static void main(String[] args) {

//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);
//		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

//		String query = " insert into student(id,name,city) values(?,?,?) ";
//		int result = template.update(query, 102, "Ritesh", "Nashik");
//		System.out.println("Updated records "+ result);

		studentDao studDao = context.getBean("studentDao", studentDao.class);
		// INSERT
		Student student = new Student();
		student.setId(105);
		student.setName("Rushi");
		student.setCity("karad");
		int result = studDao.insert(student);
		System.out.println("updated"+result);
		
		
		// UPDATE
//		Student student = new Student();
//		student.setId(102);
//		student.setName("sid");
//		student.setCity("UNR");
//		int result = studDao.change(student);
//		System.out.println("updated"+result);
		
		//DELETE
//		int result = studDao.delete(103);
//		System.out.println("Deleted "+result);
		
		// SELECT
//		Student student = studDao.getStudent(101);
//		System.out.println(student);
		
		// SELECT all students:
		List<Student> student2 = studDao.getAllStudents();
		for(Student s:student2) {
			System.out.println(s);
		}
		
	}
}
