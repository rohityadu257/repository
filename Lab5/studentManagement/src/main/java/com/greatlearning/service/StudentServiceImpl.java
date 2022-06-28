package com.greatlearning.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.model.Student;

@Repository
public class StudentServiceImpl implements StudentService  {

	private SessionFactory sessionFactory;
	private Session  session;
	
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		try {
		this.session = this.sessionFactory.getCurrentSession();
		}
		catch (HibernateException hexp) {
			this.sessionFactory.openSession();
		}
	}

	@Override
	public List<Student> findAll() {
		List <Student> allStudents =  this.session.createQuery("from student").list();
		return allStudents;
	}

	@Override
	public Student findByID(long id) {
		Student student = this.session.get(Student.class,id);
		return student;
	}
	@Transactional
	@Override
	public void Save(Student student) {
		Transaction tx = this.session.beginTransaction();
		this.session.saveOrUpdate(student);
		tx.commit();
		
	}
	@Transactional
	@Override
	public void deleteByID(long id) {
		Transaction tx = this.session.beginTransaction();
		Student student = this.session.get(Student.class,id);
		this.session.delete(student);
		tx.commit();
		
	}

	
	

}
