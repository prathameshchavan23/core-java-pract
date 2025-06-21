package com.spring.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/hibernate/config.xml");
        studentDao studentDao = context.getBean("studentDao", studentDao.class);
        Student student = new Student(107, "Prathamesh", "mumbai");
        int r = studentDao.insert(student);
        System.out.println("Record inserted: " + r);
    }
}