package com.spring.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {
	@Id
	@Column(name = "Id")
	private int studentId;

	@Column(name = "Name")
	private String studentName;

	@Column(name = "City")
	private String studentcity;

	public Student(int id, String name, String city) {
	    this.studentId = id;
	    this.studentName = name;
	    this.studentcity = city;
	}


	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentcity() {
		return studentcity;
	}

	public void setStudentcity(String studentcity) {
		this.studentcity = studentcity;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentcity=" + studentcity
				+ "]";
	}
	
	

}
