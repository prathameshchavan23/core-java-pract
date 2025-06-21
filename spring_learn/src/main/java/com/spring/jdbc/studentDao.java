package com.spring.jdbc;

import java.util.List;

public interface studentDao {

	public int insert(Student student);
	public int change(Student student);
	public int delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();
}
