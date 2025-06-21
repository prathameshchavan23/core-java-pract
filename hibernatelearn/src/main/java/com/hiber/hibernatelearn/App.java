package com.hiber.hibernatelearn;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiber.hibernatelearn.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student stud = new Student();
        
        stud.setStudentId(101);
        stud.setName("Prathamesh ");
        stud.setCollege("PES Modern college of engg");
        stud.setAbout("ENTC graduated");
     
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
       
    }
    
    
}
