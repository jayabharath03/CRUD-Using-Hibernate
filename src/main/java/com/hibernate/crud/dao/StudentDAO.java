package com.hibernate.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.crud.model.Student;
import com.hibernate.crud.util.HibernateUtil;

public class StudentDAO {

	public void saveStudent(Student student) {
		Transaction transaction = null;
		int id = 0;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			id = (int) session.save(student);
			transaction.commit();
			System.out.println("Student details saved Successfully"+id);
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		}
	}

	public void updateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
			System.out.println("Student details updated Succesfully");
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
	}

	public void deleteStudent(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Student student = session.get(Student.class, id);
			
			if (student != null) {
				session.delete(student);
				System.out.println("Student datails deleted succesfully");
			} else {
				System.out.println("id not found");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
	}

	public Student getStudent(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Student.class, id);
		}
	}

	public List<Student> getAllStudents() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Student", Student.class).list();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
}
