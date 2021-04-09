package com.app.service;

import java.util.List;

import com.app.entity.Student;

public interface StudentService {

	public Boolean saveOrUpdate(Student student);
	
	public Boolean deleteStudent(Integer id);
	
	public Student getStudentById(Integer id);
	
	public List<Student> getStudents();
}
