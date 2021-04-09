package com.app.repo.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Student;
import com.app.repo.StudentRepository;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	SessionFactory sessionFactory;

	private Boolean flag = Boolean.FALSE;

	public Boolean saveOrUpdate(Student student) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(student);
		session.beginTransaction().commit();
		flag = Boolean.TRUE;
		return flag;

	}

	public Boolean deleteStudent(Integer id) {
		Session session = sessionFactory.openSession();
		session.delete((Student)getStudentById(id));
		session.beginTransaction().commit();
		flag = Boolean.TRUE;
		return flag;
	}

	public Student getStudentById(Integer id) {
		return (Student) sessionFactory.openSession().get(Student.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudents() {
		return sessionFactory.openSession().createCriteria(Student.class).list();
	}

}
