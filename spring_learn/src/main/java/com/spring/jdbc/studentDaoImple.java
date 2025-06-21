package com.spring.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class studentDaoImple implements studentDao{

	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int insert(Student student) {
		String query = " insert into student(id,name,city) values(?,?,?) ";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	@Override
	public int change(Student student) {
		String query = "update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	@Override
	public int delete(int studentId) {
		String query = "delete from student where id=?";
		int r = this.jdbcTemplate.update(query,studentId);
		return r;
	}
	@Override
	public Student getStudent(int studentId) {
		// seleecting single student
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowmapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}
	@Override
	public List<Student> getAllStudents() {
		String query = "select * from student";
		List<Student> student = this.jdbcTemplate.query(query, new RowmapperImpl());
		return student;
	}

}
