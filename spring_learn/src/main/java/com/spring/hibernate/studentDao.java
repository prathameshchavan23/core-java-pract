package com.spring.hibernate;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import jakarta.transaction.Transactional;

public class studentDao {

	private HibernateTemplate htemplate;

	@Transactional
	public int insert(Student student) {
		Integer save = (Integer) this.htemplate.save(student);
		return save;
	}

	public Student getStudent(int studentId) {
		Student student = this.htemplate.get(Student.class, studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		List<Student> students = this.htemplate.loadAll(Student.class);
		return students;
	}

	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.htemplate.get(Student.class, studentId);
		this.htemplate.delete(student);
	}

	@Transactional
	public void updateStudent(Student student) {
		this.htemplate.update(student);
	}

	public HibernateTemplate getHtemplate() {
		return htemplate;
	}

	public void setHtemplate(HibernateTemplate htemplate) {
		this.htemplate = htemplate;
	};

}
