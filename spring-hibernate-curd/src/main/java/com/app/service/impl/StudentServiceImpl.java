package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.repo.StudentRepository;
import com.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	public Boolean saveOrUpdate(Student student) {
		return studentRepo.saveOrUpdate(student);
	}

	public Boolean deleteStudent(Integer id) {
		return studentRepo.deleteStudent(id);
	}

	public Student getStudentById(Integer id) {
		return studentRepo.getStudentById(id);
	}

	public List<Student> getStudents() {
		return studentRepo.getStudents();
	}

}
