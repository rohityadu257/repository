package com.greatlearning.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.model.student;

@Repository
public class studentServiceImpl implements studentService  {

	private SessionFactory sessionFactory;
	private Session  session;
	
	@Autowired
	public studentServiceImpl(SessionFactory sessionFactory) {
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
	public List<student> findAll() {
		List <student> allStudents =  this.session.createQuery("from student").list();
		return allStudents;
	}

	@Override
	public student findByID(long id) {
		student student = this.session.get(student.class,id);
		return student;
	}
	@Transactional
	@Override
	public void Save(student student) {
		Transaction tx = this.session.beginTransaction();
		this.session.saveOrUpdate(student);
		tx.commit();
		
	}
	@Transactional
	@Override
	public void deleteByID(long id) {
		Transaction tx = this.session.beginTransaction();
		student student = this.session.get(student.class,id);
		this.session.delete(student);
		tx.commit();
		
	}

	
	

}
